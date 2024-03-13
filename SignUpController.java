package org.example.books.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.UserBo;

import org.example.books.dto.UserDto;
import org.example.books.util.Navigation;
import org.example.books.util.Route;


import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class SignUpController {
      @FXML
    private JFXButton btnSignUp;
    @FXML
    private Text txtLogin;
    @FXML
    private Label lblId;


    @FXML
    private AnchorPane pane;

    @FXML
    private TextField txtPaasword;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtemaiAddress;

    public String Id;

    UserBo userbo=(UserBo) BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.USER);

    
   

    public void initialize() throws ClassNotFoundException, SQLException{
       // generateUserId();
    }

    private void generateUserId() {
        try{
     Id=userbo.generateUserId();
               lblId.setText(Id);
        }
        catch(Exception e){
                e.printStackTrace();
        }
}

@FXML
    void btnSignUpOnAction(ActionEvent event) {
       
     
         String name=txtUsername.getText();
         String emailAddress=txtemaiAddress.getText();
         String password=txtPaasword.getText();
         
         System.out.println("awwww");
         try{
            boolean isregistered=userbo.saveUser(name,emailAddress,password);
            if (isregistered) {
                new Alert(Alert.AlertType.CONFIRMATION, "User registered successfully.").showAndWait();
                clearFields();
                Navigation.navigate(Route.LOGIN, pane);
            }
         }catch(Exception e){
               e.printStackTrace();
         }
       
    }
   
    private void clearFields() {
    txtPaasword.setText("");
    txtUsername.setText("");
    txtemaiAddress.setText("");
    }
    @FXML
    void txtLoginOnClicked(MouseEvent event) throws IOException {
            Navigation.navigate(Route.LOGIN,pane);
    }
}
