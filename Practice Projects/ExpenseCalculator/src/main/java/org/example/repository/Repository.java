package org.example.repository;

import org.example.model.Expense;
import org.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Repository {
    Connection connection;
    public Repository() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }
    public void save(Expense expense) throws SQLException {
        String query = "insert into Expenses values (%d, '%s',%.2f)"
                .formatted(expense.getExpenseId(), expense.getExpenseDescription(), expense.getExpenseAmount());
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(query);
        if(result > 0)
            System.out.println("Saved Successfully.");
        else
            System.out.println("Error Saving Expense!");
    }
}
