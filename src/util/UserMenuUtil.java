package util;

import javax.swing.*;

public class UserMenuUtil {
    public static int validOptionUserMenu(String entry) {
        String validShowMenu = """
                Enter an option between 1 and 3
                ¿What do you want to do?
                
                1. Register
                2. Login
                3. Get out
                
                Enter your option:
                """;

        int option = 0;
        boolean validEntry = false;

        do {
            if (entry == null || entry.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You can't leave empty spaces and to exit you have to press 3");
                entry = JOptionPane.showInputDialog(null, validShowMenu);
                continue;
            }

            entry = entry.trim();

            try {
                option = Integer.parseInt(entry);
                if (option < 1 || option > 3) {
                    JOptionPane.showMessageDialog(null, "You can only enter options between 1 and 3");
                    entry = JOptionPane.showInputDialog(null, validShowMenu);
                } else {
                    validEntry = true;
                }
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Invalid character");
                entry = JOptionPane.showInputDialog(null, validShowMenu);
            }
        } while (!validEntry);

        return option;
    }
}
