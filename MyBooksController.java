package org.example.books.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class MyBooksController {
     @FXML
    private TableColumn<?, ?> columnBorrowDate;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnReturnDATE;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<?> tablemyBooks;



    public void intialize(){
        setCellValueFactory();
        getMyTransaction();
    }
    private void getMyTransaction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMyTransaction'");
    }
    private void setCellValueFactory() {
           
    }

}
