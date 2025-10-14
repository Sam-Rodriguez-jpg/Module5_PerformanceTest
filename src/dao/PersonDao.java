package dao;

import config.ConfigDB;
import interfaces.CRUD;
import model.PersonModel;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao implements CRUD<PersonModel> {
    // Check if an email already exists in the database
    public boolean emailExists(String email) {
        String sqlQuery = "SELECT COUNT(*) FROM persons WHERE email = ?";
        try (Connection connection = ConfigDB.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException error) {
            System.err.println("SQL ERROR: " + error.getMessage());
        }
        return false;
    }



    @Override
    public void create(PersonModel entity) {
        String sqlQuery = "INSERT INTO persons (name_person, email, password, role) VALUES (?, ?, ?, ?)";

        // Try - With - Resources
        try (Connection connection = ConfigDB.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getNamePerson());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getRole());
            // Execute query
            preparedStatement.executeUpdate();

            // Generated ID
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) { // For header in table
                entity.setIdPerson(resultSet.getInt(1));
            }
            System.out.println("Person registered successfully");

        } catch (SQLException error) {
            System.err.println("SQL ERROR: Problem in DB: " + error.getMessage());
        } catch (Exception error) {
            System.err.println("GENERAL ERROR: " + error.getMessage());
        }
    }

    @Override
    public List<PersonModel> findAll() {
        List<PersonModel> people = new ArrayList<>();
        String sqlQuery = "SELECT * FROM persons";

        try (Connection connection = ConfigDB.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                PersonModel personModel = new PersonModel(
                        resultSet.getInt("id_person"),
                        resultSet.getString("name_person"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );

                people.add(personModel);
            }

        } catch (SQLException error) {
            System.err.println("SQL ERROR: Problem in DB: " + error.getMessage());
        } catch (Exception error) {
            System.err.println("GENERAL ERROR: " + error.getMessage());
        }

        return people;
    }


    // TIME FOR THIS :(?????
    @Override
    public PersonModel findById(int id) {
        return null;
    }

    @Override
    public void update(PersonModel entity) {

    }

    @Override
    public void delete(PersonModel entity) {

    }
}
