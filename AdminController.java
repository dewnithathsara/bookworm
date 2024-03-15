package org.example.books.controller;



import java.io.IOException;

import org.example.books.util.Navigation;
import org.example.books.util.Route;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class AdminController {
    @FXML
    private JFXButton btnBorrowing;

    @FXML
    private TableColumn<?, ?> bookId;

    @FXML
    private TableColumn<?, ?> bookName;

    @FXML
    private AnchorPane pane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<?> tablebook;

    @FXML
    private TextField tstsearch;

    @FXML
    private TableColumn<?, ?> uthor;
    @FXML
    private JFXButton btnLibrary;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnTransaction;

    @FXML
    private JFXButton btnbook;

    public void Initialize(){
       setCellValueFactory();
    }
    private void setCellValueFactory() {
    }

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Route.BOOK,pane);

    }

    @FXML
    void btnLibraryOnAction(ActionEvent event) throws IOException {
       Navigation.navigate(Route.LIBRARYBRANCH,pane);
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Route.LOGIN,rootPane);

    }
    @FXML
    void btnTransactionOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Route.TRANSACTIONMANAGE,pane);
    }

    @FXML
    void searchOnPressed(KeyEvent event) {

    }
    @FXML
    void BtnBorrowingOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Route.BORROWINGBOOKS, pane);
    }

}
