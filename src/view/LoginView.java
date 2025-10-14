package view;

import controller.LoginController;

import static util.ValidEntriesUtil.*;

public class LoginView {
    private final LoginController loginController = new LoginController();

    public void loginMenuView() {
        String email = validString("Enter your email:");
        String password = validString("Enter your password");

        loginController.loginPerson(email, password);
    }
}
