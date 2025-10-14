package util;

import dao.PersonDao;

import javax.swing.*;

import javax.swing.JOptionPane;

public class ValidEntriesUtil {

    // Validation for empty inputs
    public static String validString(String message) {
        String entry;
        do {
            entry = JOptionPane.showInputDialog(null, message);
            // Validation to ensure user doesn’t cancel or leave the field empty
            if (entry == null || entry.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You cannot leave empty spaces or cancel the input.");
            }
            // Keeps asking until the user provides a valid entry
        } while (entry == null || entry.trim().isEmpty());

        // Returns the trimmed input to be used later in the service layer
        return entry.trim();
    }



    // Validation for only positive integers
    public static int validOnlyPositiveInts(String message) {
        int positiveNumber = -1;
        String entry;
        boolean valid = false;

        do {
            entry = validString(message);
            try {
                positiveNumber = Integer.parseInt(entry);
                if (positiveNumber < 0) {
                    JOptionPane.showMessageDialog(null, "Only positive values are allowed.");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Only positive integer numbers are allowed.");
            }
        } while (!valid);

        return positiveNumber;
    }



    // Validation for email format
    public static String validEmail(String message) {
        PersonDao personDao = new PersonDao();
        String entry;
        boolean valid = false;

        do {
            entry = validString(message);

            // 1. Check format
            if (!(entry.contains("@") && entry.contains("email.com"))) {
                JOptionPane.showMessageDialog(null, "WARNING: The email must include '@' and the domain 'email.com'.");
                continue;
            }

            // 2. Check if email already exists in DB
            if (personDao.emailExists(entry)) {
                JOptionPane.showMessageDialog(null, "ERROR: This email is already registered. Please use another one.");
                continue;
            }
            valid = true;

        } while (!valid);

        return entry.trim();
    }

    // Password length validation
    public static String validPassword(String message) {
        String entry;
        boolean valid = false;
        int minCharacters = 6;
        int maxCharacters = 255;

        do {
            entry = validString(message);
            if (entry.length() < minCharacters || entry.length() > maxCharacters) {
                JOptionPane.showMessageDialog(null, "Your password must be between " + minCharacters + " and " + maxCharacters + " characters long.");
            } else {
                valid = true;
            }
        } while (!valid);

        return entry.trim();
    }



    // Validation for role
    public static String validRole() {
        boolean rolValid = false;
        String role = "";

        while (!rolValid) {
            String rolEntry = validString("What is your role [Partner/User]?:");
            if (!rolEntry.equalsIgnoreCase("User") && !rolEntry.equalsIgnoreCase("Partner")) {
                JOptionPane.showMessageDialog(null, "There is no such role, only User or Partner");
            } else {
                role = rolEntry;
                rolValid = true;
            }
        }
        return role;
    }
}