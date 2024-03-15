package org.example.books.controller;

import java.io.IOException;
import java.util.List;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.TransactionBo;
import org.example.books.dto.BookDto;
import org.example.books.dto.TransactionDto;
import org.example.books.tm.BookTm;
import org.example.books.tm.TransactionTm;
import org.example.books.util.Navigation;
import org.example.books.util.Route;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<TransactionTm> tableDue;

    public void initialize(){
        setCellValueFactory();
        getDueBook();
    } 
    TransactionBo bo=(TransactionBo)BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.TRANSACTION);

    private void getDueBook() {
        try{ObservableList<TransactionTm> obList = FXCollections.observableArrayList();
                List<TransactionDto> dtolist=bo.getBookDetails();
                for(TransactionDto dtos:dtolist ){
                    obList.add(new TransactionTm(dtos.getBookname(),dtos.getDueDate()));
                }
                tableDue.setItems( obList);
         }catch(Exception e){
            throw new RuntimeException(e);
         }
       
    }

    private void setCellValueFactory() {
        columnbook.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        columnDueDte.setCellValueFactory(new PropertyValueFactory<>( "due date"));
           
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
