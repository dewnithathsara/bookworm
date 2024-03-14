package org.example.books.controller;

import java.io.IOException;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.AdminBo;
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

public class AdminLoginController {
      @FXML
        private JFXButton btnLogin;
    
        @FXML
        private AnchorPane pane;
    
        @FXML
        private TextField textEmail;
    
        @FXML
        private TextField textPassword;
    
        @FXML
        private Text textSIgnUp;
        AdminBo adminBo=(AdminBo)BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.ADMIN);

        @FXML
        void SignUpOnMouseClicked(MouseEvent event) throws IOException {
             Navigation.navigate(Route.ADMINSIGNUP,pane);
        }
    
        @FXML
        void btnLoginOnAction(ActionEvent event) {
            String email=textEmail.getText();
            String password=textPassword.getText();
            var dto=new UserDto(email,password);
            try{
                boolean isLogined=adminBo.adminLogin(dto);
                if(isLogined){
                    new Alert(Alert.AlertType.CONFIRMATION,"Successfully logined").showAndWait();
                    clearFeilds();
                    Navigation.navigate(Route.ADMIN,pane);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        private void clearFeilds() {
          
            textEmail.setText("");
            textPassword.setText("");
        }




}
