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
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<TransactionTm> tablemyBooks;

    TransactionBo bo=(TransactionBo)BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.TRANSACTION);


    public void intialize(){
        setCellValueFactory();
        getMyTransaction();
    }
    private void getMyTransaction() {
        try{ObservableList<TransactionTm> obList = FXCollections.observableArrayList();
                List<TransactionDto> dtoList=bo.getMybooks();
                for(TransactionDto dtos:dtoList ){
                    obList.add(new TransactionTm(dtos.getBookname(),dtos.getBorrowed(),dtos.getReturnedDate()));
                }
                tablemyBooks.setItems( obList);
         }catch(Exception e){
            throw new RuntimeException(e);
         }
    }
    private void setCellValueFactory() {
            columnName.setCellValueFactory(new PropertyValueFactory<>("book name"));
         columnBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowed"));
         columnReturnDATE.setCellValueFactory(new PropertyValueFactory<>("returned"));

    }

}
