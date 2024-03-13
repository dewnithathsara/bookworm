package org.example.books.controller;
import java.io.IOException;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.UserBo;
import org.example.books.dto.UserDto;
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
public class LoginController {
    @FXML
    private JFXButton btnLogin;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtusername;
     @FXML
    private Text txtSignUp;
    UserBo userbo=(UserBo) BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.USER);
    @FXML
    void signUpOnClicked(MouseEvent event) throws IOException {
        Navigation.navigate(Route.SIGNUP,pane);

    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String name=txtusername.getText();
       
         String password=txtpassword.getText();
         var dto=new UserDto(name,password);
         System.out.println("awwww");
         try{
            boolean isregistered=userbo.login(dto);
            if (isregistered) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Logined successfully.").showAndWait();
                clearFields();
                Navigation.navigate(Route.SIDEPANEL,pane);
               // Navigation.navigate(Route.LOGIN, pane);
            }else{
                if(txtusername.equals("admin")&(txtpassword.equals("12345678#"))){
                    new Alert(Alert.AlertType.CONFIRMATION, "Admin Logined successfully.").showAndWait();
                    clearFields();
                }
            }
         }catch(Exception e){
               e.printStackTrace();
         }

    }

    private void clearFields() {
        txtpassword.setText("");
        txtusername.setText("");
    }
}
