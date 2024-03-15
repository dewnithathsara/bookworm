package org.example.books.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import org.example.books.util.Navigation;
import org.example.books.util.Route;

import com.jfoenix.controls.JFXButton;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private JFXButton btnSignUp;
   
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private Text textLogin;

    @FXML
    void LoginOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.navigate(Route.ADMINLOGIN,pane);
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
       Navigation.navigate(Route.SIGNUP, pane);

    }
   
    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
       Navigation.navigate(Route.LOGIN, pane);
    }

}