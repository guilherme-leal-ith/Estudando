package br.com.guilhermeleal;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/coursejdbc";
        String user = "root", password = "Attackontitan1@";

        String sql1 = "UPDATE seller SET BaseSalary = ? WHERE DepartmentId = ?";
        String sql2 = "UPDATE seller SET BaseSalary = ? WHERE DepartmentId = ?";

        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            conn = DriverManager.getConnection(url, user, password);//getConnection lança SQLException
            conn.setAutoCommit(false);//setAutoCommit lança SQL

            ps1 = conn.prepareStatement(sql1);//prepareStatement lança SQL
            ps1.setDouble(1, 15000);
            ps1.setInt(2, 1);
            ps1.executeUpdate();

            /*int x = 1;
            if (x == 1) {
                throw new SQLException("Erro proposital");
            }*/

            ps2 = conn.prepareStatement(sql2); //prepareStatement lança SQL
            ps2.setDouble(1, 18000);
            ps2.setInt(2, 2);
            ps2.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();//rollback lança SQL
                    System.out.println("Error caused a rollback: " + e.getMessage());
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.close();
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}