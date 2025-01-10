package org.example;

import org.example.model.Expense;
import org.example.repository.Repository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Repository repository = new Repository();
        Expense expense = new Expense(1, "Flight Tickets", 10000);
        repository.save(expense);
    }
}