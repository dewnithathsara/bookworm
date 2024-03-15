package org.example.books.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.TransactionBo;
import org.example.books.dto.TransactionDto;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TransactionController {
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TextField txtsearch;
    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtBorrowed;

    @FXML
    private TextField txtDue;

    @FXML
    private TextField txtReturned;
    @FXML
    private JFXButton btnHistory;
    @FXML
    private TextField txtUserId;
    TransactionBo bo=(TransactionBo)BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.TRANSACTION);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException {
      Long userId=Long.parseLong(txtUserId.getText());
      String bookName=txtBookName.getText();
      String borrowed=txtBorrowed.getText();
      String due=txtDue.getText();
      String returned=txtReturned.getText();
      try{
      var dto=new TransactionDto(borrowed,due,returned);
      bo.saveTransaction(userId,bookName,dto);
      new Alert(Alert.AlertType.CONFIRMATION,"successful").showAndWait();

      }catch(Exception e){
        e.printStackTrace();
      }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event)  {
        Long userId=Long.parseLong(txtUserId.getText());
      String bookName=txtBookName.getText();
      String borrowed=txtBorrowed.getText();
      String due=txtDue.getText();
      String returned=txtReturned.getText();
      var dto=new TransactionDto(userId,bookName,borrowed,due,returned);
      boolean isUpdated;
    try {
        isUpdated = bo.update(dto);
        if(isUpdated){
           new Alert(Alert.AlertType.CONFIRMATION,"succesfull").showAndWait();
        }else{
            new Alert(Alert.AlertType.ERROR,"something went wrong").showAndWait();
 
        }
    } catch (SQLException e) {
       
        e.printStackTrace();
    }
      
    }

    @FXML
    void searchOnAction(ActionEvent event) {
        Long id=Long.parseLong(txtsearch.getText());
        TransactionDto dto=bo.search(id);
        if(dto!=null){
            fillData(dto);
        }else{
            new Alert(Alert.AlertType.ERROR,"something went wrong").showAndWait();
            txtsearch.setText("");
        }
    }

    private void fillData(TransactionDto dto) {
        txtUserId.setText(String.valueOf(dto.getUserId()));
        txtBookName.setText(dto.getBookname());
        txtBorrowed.setText(String.valueOf(dto.getBorrowed()));
        txtBorrowed.setText(String.valueOf(dto.getDueDate()));
        txtBorrowed.setText(String.valueOf(dto.getReturnedDate()));
    }
    @FXML
    void btnHistoryOnAction(ActionEvent event) {

    }
}
