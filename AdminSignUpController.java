package org.example.books.controller;

import java.io.IOException;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.AdminBo;
import org.example.books.util.Navigation;
import org.example.books.util.Route;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AdminSignUpController {

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textName;

    @FXML
    private TextField textPassword;

    @FXML
    private Text textSignUp;
    AdminBo adminBo=(AdminBo)BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.ADMIN);

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        String name=textName.getText();
        String email=textEmail.getText();
        String password=textPassword.getText();
        try{
            boolean isregistered=adminBo.saveAdmin(name,email,password);
            if(isregistered){
               new Alert(Alert.AlertType.CONFIRMATION,"Successfully registered").showAndWait();
              clearFields();
               Navigation.navigate(Route.ADMINLOGIN,pane);
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong").showAndWait();
            }
        }catch(Exception e){
           e.printStackTrace();
        }

    }

    private void clearFields() {
       textName.setText("");
       textEmail.setText("");
       textPassword.setText("");
       
    }

    @FXML
    void textSignUpOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Route.ADMINLOGIN,pane);
    }
}
