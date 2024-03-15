package org.example.books.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BorrowingBooksController {
   
    @FXML
    private JFXComboBox<?> MyBookS;

    @FXML
    private JFXButton btnBorrow;

    @FXML
    private JFXButton btnReturn;

    @FXML
    private TextField textBookId;

    @FXML
    private TextField textSearch;

    @FXML
    private TextField textname;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBranch;

    @FXML
    private TextField txtgenere;

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {

    }
 
}
