package br.com.guilhermeleal;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/coursejdbc";
        String user = "root", password = "Attackontitan1@";

        String sql = "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId)" +
                "VALUES (?, ?, ?, ?, ?)";

        String sql2 = "INSERT INTO department (Name)" +
                "VALUES (?), (?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS)
             //Statement st = conn.createStatement();
             //ResultSet rs = st.executeQuery("SELECT * FROM department");
        ){
            System.out.println("Banco conectado!\n");

            ps.setString(1, "Art");
            ps.setString(2, "Furniture");
            /*
            ps.setString(1, "Dudacaz");
            ps.setString(2, "dudacaz@gmail.com");
            ps.setDate(3, Date.valueOf("2006-06-11"));
            ps.setDouble(4, 10000);
            ps.setInt(5, 3);*/

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()){
                    while (rs.next()) {
                        int newDep = rs.getInt(1);
                        System.out.println("Novo departamento: " + newDep);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException("Erro no ResultSet: " + e);
                }
            }

            System.out.println("Linhas atualizadas: " + rowsAffected);
            //while (rs.next()) { System.out.println(rs.getInt("Id") + ", " + rs.getString("Name")); }


        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar: ", e);
        }
    }
}