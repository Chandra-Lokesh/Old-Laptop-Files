package com.ust.traineeapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionUtil {

//    private static final String url = "jdbc:mysql://localhost:3307/ust_db";
    private static final String url = "jdbc:postgresql://localhost:5432/ust_db";
    private static final String username = "postgres";
    private static final String password = "postgres";

    public static Connection createConnection(){
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
