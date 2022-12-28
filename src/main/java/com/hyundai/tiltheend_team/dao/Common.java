package com.hyundai.tiltheend_team.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Common {
    public Statement getStatement() {
        String url = "jdbc:mysql://localhost:3306/simple_tiltheend";
        String user = "root";
        String password = "*khacademy!";

        Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
