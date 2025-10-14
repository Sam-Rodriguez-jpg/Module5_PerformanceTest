package dao;

import config.ConfigDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PartnerDao {
    public void create(int idPerson) {
        String sqlQuery = "INSERT INTO partners (id_person) VALUES (?)";
        try(Connection connection = ConfigDB.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, idPerson);
            preparedStatement.executeUpdate();

        } catch (SQLException error) {
            System.err.println("SQL ERROR: Problem in DB: " + error.getMessage());
        } catch (Exception error) {
            System.err.println("GENERAL ERROR: " + error.getMessage());
        }
    }
}
