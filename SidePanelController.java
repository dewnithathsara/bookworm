package org.example.books.controller;

import java.io.IOException;

import org.example.books.util.Navigation;
import org.example.books.util.Route;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class SidePanelController {
     @FXML
    private JFXButton btnBorrow;

    @FXML
    private JFXButton btnHomeOnAction;

    @FXML
    private JFXButton btnLOgOUt;

    @FXML
    private JFXButton btnMyBooks;

    @FXML
    private JFXButton btnMyProfile;

    @FXML
    private TableColumn<?, ?> columnDueDte;

    @FXML
    private TableColumn<?, ?> columnbook;

    @FXML
    private AnchorPane pane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<?> tableDue;

    public void initialize(){
        setCellValueFactory();
        getDueBook();
    } 

    private void getDueBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDueBook'");
    }

    private void setCellValueFactory() {
           
    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Route.BORROWBOOKS,pane);
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
       Navigation.navigate(Route.ADMIN,rootPane);
    }

    @FXML
    void btnMyBookOnAction(ActionEvent event) throws IOException {
       Navigation.navigate(Route.MYBOOKS,pane);
    }

    @FXML
    void btnMyprofileOnAction(ActionEvent event) {

    }
 
    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Route.LOGIN,rootPane);
    }
    
}
