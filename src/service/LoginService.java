package service;

import dao.LoginDao;
import model.PersonModel;

import javax.swing.*;

public class LoginService {
    private final LoginDao loginDao = new LoginDao();

    public PersonModel login(String email, String password) {
        PersonModel personModel = loginDao.login(email, password);

        if (personModel == null) {
            JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
        } else {
            JOptionPane.showMessageDialog(null, "Welcome back " + personModel.getNamePerson() + "!");
        }

        return personModel;
    }
}
