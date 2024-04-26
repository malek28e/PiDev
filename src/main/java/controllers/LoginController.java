package controllers;

import Entite.User;
import Utils.DataSource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import Services.UserService;

import java.io.IOException;
import java.sql.Connection;


public class LoginController{

    private UserService userService;
    public LoginController() {
        userService = new UserService();
    }
    @FXML
    private TextField enteredPassword;

    @FXML
    private TextField enteredUsername;
    public void loginButtonOnAction(ActionEvent event){
        String username = enteredUsername.getText();
        String password = enteredPassword.getText();
         User user = new User (username,password);

         if (!username.isBlank() && !password.isBlank()) {
            boolean loggedIn = userService.login(user);
            if (loggedIn) {
                loginMessage.setText("Login Successful!");

            } else {
                loginMessage.setText("Invalid username or password!");
            }
        } else {
            loginMessage.setText("Veuillez remplir tous les champs");
        }
    }
    public void validateLogin(){

    }
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessage;


    @FXML
    private Button cancelButton;
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Hyperlink redirectToSignup;

    @FXML
    void redirectToSignupClicked(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/SignUp.fxml"));
            Parent root = fxmlLoader.load();
            enteredUsername.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
