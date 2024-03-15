package org.example.books.controller;

import java.util.List;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.TransactionBo;
import org.example.books.dto.BookDto;
import org.example.books.dto.TransactionDto;
import org.example.books.tm.BookTm;
import org.example.books.tm.TransactionTm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<TransactionTm> tableHistory;

    @FXML
    private TextField txtsearch;

    TransactionBo bo=(TransactionBo)BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.TRANSACTION);

    public void Initialize(){
        setCellValueFactory();
     }

    @FXML
    void searchOnAction(ActionEvent event) {
        getMyTransaction();

    }
   
     private void getMyTransaction() {
       String username= txtsearch.getText();
                try{ObservableList<TransactionTm> obList = FXCollections.observableArrayList();
                List<TransactionDto> dtolist=bo.getHistory(username);
                    for(TransactionDto dtos:dtolist ){
                       obList.add(new TransactionTm(dtos.getTransactionId(),dtos.getBook(),dtos.getBookname(),dtos.getBorrowed(),dtos.getReturnedDate()));
                    }
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
    }

    private void setCellValueFactory() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
         columnBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
         columnBookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
         columnBorrowed.setCellValueFactory(new PropertyValueFactory<>("borrowed date"));
         columnRetuened.setCellValueFactory(new PropertyValueFactory<>("retuturned date"));

     } 
    


}
