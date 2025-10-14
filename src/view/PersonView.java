package view;

import controller.PersonController;
import model.PersonModel;

import javax.swing.*;

import java.util.List;

import static util.ValidEntriesUtil.*;

public class PersonView {
    private final PersonController personController = new PersonController();

    // Create
    public void registerMenuView() {
        String namePerson = validString("Enter name:");
        String email = validEmail("Enter email:");
        String password = validPassword("Enter password:");
        String role = validRole();

        personController.registerPerson(namePerson, email, password, role);
        JOptionPane.showMessageDialog(null, "Registration completed successfully!");
    }

    // Find All
    public void showAllPeople() {
        List<PersonModel> users = personController.listAllPeople();

        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No users found.");
            return;
        }

        String list = "Users in LibroNova\n\n";
        for (PersonModel person : users) {
            list += "ID: " + person.getIdPerson()
                    + " | Name: " + person.getNamePerson()
                    + " | Email: " + person.getEmail()
                    + " | Role: " + person.getRole()
                    + "\n";
        }

        JOptionPane.showMessageDialog(null, list);
    }

}
