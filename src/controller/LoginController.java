package controller;

import dao.LoginDao;
import model.PersonModel;

import javax.swing.*;

import static view.UserMenuView.userMenu;

public class LoginController {
    private final LoginDao loginDao = new LoginDao();

    public void loginPerson(String email, String password) {
        PersonModel personModel = loginDao.login(email, password);

        if (personModel != null) {
            if (personModel.getRole().equalsIgnoreCase("User")) {
                userMenu();
            } else if (personModel.getRole().equalsIgnoreCase("Partner")) {
                System.out.println("Partner Menu");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Invalid email or password.");
        }
    }
}
