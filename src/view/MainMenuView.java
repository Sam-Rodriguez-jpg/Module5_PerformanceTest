package view;

import javax.swing.*;

import static util.MainMenuUtil.validOptionMainMenu;

public class MainMenuView {
    public static void menu() {
        int option;


        do {
            String entry = JOptionPane.showInputDialog(null, """
                Welcome to LibroNova
                ¿What do you want to do?
                
                1. Register
                2. Login
                3. Get out
                
                Enter your option:
                """
            );
            option = validOptionMainMenu(entry);

            switch (option) {
                case 1:
                    PersonView registerView = new PersonView();
                    registerView.registerMenuView();
                    break;
                case 2:
                    LoginView loginView = new LoginView();
                    loginView.loginMenuView();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Thank you for using LibroNova!\n See you later :)");
                    break;
            }

        } while (option != 3);
    }
}
