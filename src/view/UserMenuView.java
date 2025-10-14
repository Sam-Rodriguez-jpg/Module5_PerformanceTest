package view;

import javax.swing.*;

import static util.UserMenuUtil.validOptionUserMenu;

public class UserMenuView {
    public static void userMenu() {
        int option;


        do {
            String entry = JOptionPane.showInputDialog(null, """
                Welcome to LibroNova
                ¿What do you want to do?
                
                1. Read all users
                2. Create a book
                3. Get out
                
                Enter your option:
                """
            );
            option = validOptionUserMenu(entry);

            switch (option) {
                case 1:
                    PersonView personView = new PersonView();
                    personView.showAllPeople();
                    break;
                case 2:
                    BookView bookView = new BookView();
                    bookView.createBook();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Thank you for using LibroNova!\n See you later :)");
                    break;
            }

        } while (option != 3);
    }
}
