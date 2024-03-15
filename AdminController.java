package org.example.books.controller;



import java.io.IOException;
import java.util.List;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.BookBo;
import org.example.books.dto.BookDto;
import org.example.books.tm.BookTm;
import org.example.books.util.Navigation;
import org.example.books.util.Route;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<BookTm> tablebook;

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
        BookBo bookBo=(BookBo)BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.BOOK);


    public void Initialize(){
       setCellValueFactory();
       getBookDetails();
    }
    private void getBookDetails() {
         try{ObservableList<BookTm> obList = FXCollections.observableArrayList();
                List<BookDto> booklist=bookBo.getBookDetails();
                for(BookDto bookDto:booklist ){
                    obList.add(new BookTm(bookDto.getBookId(),bookDto.getTitle(),bookDto.getGenre()));
                }
                tablebook.setItems( obList);
         }catch(Exception e){
            throw new RuntimeException(e);
         }
    }
    private void setCellValueFactory() {
         bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
         bookName.setCellValueFactory(new PropertyValueFactory<>("bookname"));
         uthor.setCellValueFactory(new PropertyValueFactory<>("author"));

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
