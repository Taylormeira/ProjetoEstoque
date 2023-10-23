package controllers;

import conections.ConnectionDataBase;
import models.EstoqueModels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class EstoqueController {
    ConnectionDataBase connection = new ConnectionDataBase();

    public void createEstoque(String descEstoque, String location) throws SQLException {
        System.out.println("criar Estoque");
        try (Connection conn = connection.connectionDb()) {

            try (PreparedStatement statement = conn.prepareStatement("insert into tb_Estoque (CodEstoque, DescEstoque, Location) value (?,?,?)")) {
                int index = 0;

                statement.setString(++index, UUID.randomUUID().toString());
                statement.setString(++index, descEstoque);
                statement.setString(++index, location);

                System.out.println("statement = " + statement);

                statement.executeUpdate();
            }
        }
    }

    public void alterEstoque(UUID codEstoque, String descEstoque, String location) {
        System.out.println("Estoque alteradp");

        try (Connection conn = connection.connectionDb()) {
            try (PreparedStatement statement = conn.prepareStatement("update tb_Estoque set DescEstoque = ?, Location = ? where CodEstoque = ?")) {
                int index = 0;

                statement.setString(++index, descEstoque);
                statement.setString(++index, location);
                statement.setObject(++index, codEstoque);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados");
        }
    }

    public void deleteEstoque() {
        System.out.println("Estoque Deletado");
    }

    public void viewEstoque() {
        System.out.println("Visualiza o estoque");
    }

    // Metodo que insere nosso moch.
    public List<EstoqueModels> loadEstoque() {
        return List.of(
                EstoqueModels.mock(),
                EstoqueModels.mock(),
                EstoqueModels.mock(),
                EstoqueModels.mock(),
                EstoqueModels.mock(),
                EstoqueModels.mock()
        );
    }
}

