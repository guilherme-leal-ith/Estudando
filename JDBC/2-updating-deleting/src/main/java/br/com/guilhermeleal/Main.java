package br.com.guilhermeleal;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/coursejdbc";
        String user = "root", password = "Attackontitan1@";

        /* ATUALIZANDO TABELA
        String sql = "UPDATE seller " +
                "SET BaseSalary = ? " +
                "WHERE Name = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setDouble(1,20000);
            ps.setString(2, "Dudacaz");

            int rowsUpdated = ps.executeUpdate();
            System.out.println("Linhas atualizadas: " + rowsUpdated);

        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }*/

        //DELETANDO DADOS

        String sql2 = "DELETE FROM seller WHERE Id IN (?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = con.prepareStatement(sql2)) {

            ps.setInt(1, 7);
            ps.setInt(2, 8);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Linhas deletadas: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}