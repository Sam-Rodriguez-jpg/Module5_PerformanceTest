package dao;

import config.ConfigDB;
import model.PersonModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public PersonModel login(String email, String password) {
        String sqlQuery = "SELECT * FROM persons WHERE email = ? AND password = ?";
        PersonModel personModel = null;

        try (Connection connection = ConfigDB.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                personModel = new PersonModel(
                        resultSet.getInt("id_person"),
                        resultSet.getString("name_person"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            }
        } catch (SQLException error) {
            System.err.println("SQL ERROR: Problem in DB: " + error.getMessage());
        } catch (Exception error) {
            System.err.println("GENERAL ERROR: " + error.getMessage());
        }

        return personModel;
    }
}
