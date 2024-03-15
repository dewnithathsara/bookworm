package org.example.books.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HistoryController {
    @FXML
    private TableColumn<?, ?> columnBookId;

    @FXML
    private TableColumn<?, ?> columnBookName;

    @FXML
    private TableColumn<?, ?> columnBorrowed;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnRetuened;

    @FXML
    private TableView<?> tableHistory;

    @FXML
    private TextField txtsearch;


    public void Initialize(){
        setCellValueFactory();
     }

    @FXML
    void searchOnAction(ActionEvent event) {
        getMyTransaction();

    }
   
     private void getMyTransaction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMyTransaction'");
    }

    private void setCellValueFactory() {
     } 
    


}
