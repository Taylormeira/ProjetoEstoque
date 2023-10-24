package controllers;

import conections.ConnectionDataBase;
import models.EstoqueModels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EstoqueController {
    ConnectionDataBase connection = new ConnectionDataBase();

    public void insert(EstoqueModels estoque) throws SQLException {
        try (Connection conn = connection.connectionDb()) {

            try (PreparedStatement statement = conn.prepareStatement("insert into tb_Estoque (CodEstoque, DescEstoque, Location) value (?,?,?)")) {
                int index = 0;

                statement.setString(++index, UUID.randomUUID().toString());
                statement.setString(++index, estoque.getDescEstoque());
                statement.setString(++index, estoque.getLocation());

                System.out.println("statement = " + statement);

                statement.executeUpdate();
            }
        }
    }

    public Optional<EstoqueModels> selectById(UUID codEstoque) throws SQLException {
        try (Connection conn = connection.connectionDb()) {
            try (PreparedStatement statement = conn.prepareStatement("select CodEstoque, DescEstoque, Location from tb_Estoque where CodEstoque = ?")) {
                statement.setString(1, codEstoque.toString());
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        EstoqueModels estoqueModels = new EstoqueModels();
                        estoqueModels.setCodEstoque(UUID.fromString(resultSet.getString("CodEstoque")));
                        estoqueModels.setDescEstoque(resultSet.getString("DescEstoque"));
                        estoqueModels.setLocation(resultSet.getString("Location"));

                        return Optional.of(estoqueModels);
                    } else {
                        return Optional.empty();
                    }

                }
            }
        }
    }

    public void alter(EstoqueModels estoque) throws SQLException {
        try (Connection conn = connection.connectionDb()) {
            try (PreparedStatement statement = conn.prepareStatement("update tb_Estoque set DescEstoque = ?, Location = ? where CodEstoque = ?")) {
                int index = 0;

                statement.setString(++index, estoque.getDescEstoque());
                statement.setString(++index, estoque.getLocation());
                statement.setObject(++index, estoque.getCodEstoque().toString());

                statement.executeUpdate();
            }
        }
    }

    public List<EstoqueModels> selectAll() throws SQLException {
        try (Connection conn = connection.connectionDb()) {
            try (PreparedStatement statement = conn.prepareStatement("select CodEstoque, DescEstoque, Location from tb_Estoque order by 1")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<EstoqueModels> listaEstoque = new ArrayList<>();

                    while (resultSet.next()) {
                        EstoqueModels estoqueModels = new EstoqueModels();
                        estoqueModels.setCodEstoque(UUID.fromString(resultSet.getString("CodEstoque")));
                        estoqueModels.setDescEstoque(resultSet.getString("DescEstoque"));
                        estoqueModels.setLocation(resultSet.getString("Location"));

                        listaEstoque.add(estoqueModels);

                    }
                    return listaEstoque;
                }
            }
        }
    }

    public void delete() {
        System.out.println("Estoque Deletado");
    }
}
