package com.bookstoreapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url = "jdbc:postgresql://localhost:5432/bookstore_db";
    private static final String username = "postgres";
    private static final String password = "postgres";

    public static Connection createConnection(){

        Connection connection;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}
