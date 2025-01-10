package com.bookstoreapp.repository;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.util.DatabaseConnection;

import javax.swing.text.html.Option;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository{


    Connection connection;

    public BookRepositoryImpl() {
        connection = DatabaseConnection.createConnection();
    }

    @Override
    public List<Book> findAll() {
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from books");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSetToBookList(resultSet);
    }

    @Override
    public Optional<Book> findById(int id) {
        String query = "select * from books where id = " + id;
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(resultSetToBook(resultSet));
    }

    @Override
    public Book save(Book book) {
//        String query = """
//        insert into books values (%d, '%s', '%s', %d, %d, %lf)
//        """.formatted(book.getId(),book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getIsbn(), book.getPrice());
        String query = "insert into books values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getPublicationYear());
            preparedStatement.setLong(5, book.getIsbn());
            preparedStatement.setDouble(6, book.getPrice());
            int rowCount = preparedStatement.executeUpdate();
            System.out.println(rowCount + " row updated!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from books where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book update(Book book) {
        String query = "update books set publicationyear = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, book.getPublicationYear());
            preparedStatement.setInt(2, book.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet;
        query = "select * from books where id = " + book.getId();
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSetToBook(resultSet);
    }

    public List<Book> resultSetToBookList(ResultSet resultSet){
        List<Book> bookList = new ArrayList<>();
        int id, publicationYear;
        String title, author;
        long isbn;
        double price;

        try{
            while(resultSet.next()){
                id = resultSet.getInt("id");
                title = resultSet.getString("title");
                author = resultSet.getString("author");
                publicationYear = resultSet.getInt("publicationYear");
                isbn = resultSet.getLong("isbn");
                price = resultSet.getDouble("price");
                bookList.add(new Book(id, title, author, publicationYear, isbn, price));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return bookList;
    }
    public Book resultSetToBook(ResultSet resultSet){
        int id, publicationYear;
        String title, author;
        long isbn;
        double price;
        try{
            if(resultSet.next()){
                id = resultSet.getInt("id");
                title = resultSet.getString("title");
                author = resultSet.getString("author");
                publicationYear = resultSet.getInt("publicationYear");
                isbn = resultSet.getLong("isbn");
                price = resultSet.getDouble("price");
                return new Book(id, title, author, publicationYear, isbn, price);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
