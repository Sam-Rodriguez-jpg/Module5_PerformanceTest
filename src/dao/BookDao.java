package dao;

import config.ConfigDB;
import interfaces.CRUD;
import model.BookModel;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class BookDao implements CRUD<BookModel> {

    @Override
    public void create(BookModel entity) {
        String sqlQuery = "INSERT INTO books (name_book, stock, ISBN) VALUES (?, ?, ?)";
        try (Connection connection = ConfigDB.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getNameBook());
            preparedStatement.setInt(2, entity.getStock());
            preparedStatement.setString(3, entity.getIsbn());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                entity.setIdBook(resultSet.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Book registered successfully");

        } catch (SQLException error) {
            System.err.println("SQL ERROR: Problem in DB: " + error.getMessage());
        } catch (Exception error) {
            System.err.println("GENERAL ERROR: " + error.getMessage());
        }
    }

    @Override
    public List<BookModel> findAll() {
        return List.of();
    }










    // NO TIMEEE :(
    @Override
    public BookModel findById(int id) {
        return null;
    }

    @Override
    public void update(BookModel entity) {

    }

    @Override
    public void delete(BookModel entity) {

    }
}
