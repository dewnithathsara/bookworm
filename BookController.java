package org.example.books.controller;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.BookBo;
import org.example.books.dto.BookDto;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class BookController {
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TextField textauthor;

    @FXML
    private TextField textauthors;

    @FXML
    private TextField textgenere;

    @FXML
    private TextField textstatus;

    @FXML
    private TextField texttitle;

    @FXML
    private TextField txtsearch;

    BookBo bookBo=(BookBo)BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.BOOK);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String name=texttitle.getText();
       try{
        boolean isDeleted=bookBo.delete(name);
        if(isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"book deleted").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"book not deleted");
        }
    }catch(Exception e){
        new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
    }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String name=texttitle.getText();
        String author=textauthor.getText();
        String genere=textgenere.getText();
        Long branch=Long.parseLong(textauthors.getText());
        boolean status=Boolean.parseBoolean(textstatus.getText());
        try{
           // var dto=new BookDto(name,author,genere,status,branch);
            boolean isSaved= bookBo.save(name,author,genere,branch);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"successfully saved").showAndWait();
                clearFields();
            }else{
                new Alert(Alert.AlertType.ERROR,"something went wrong").showAndWait();
                 clearFields();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void clearFields() {
        textauthor.setText("");
        textauthors.setText("");
        textgenere.setText("");
        textstatus.setText("");
        texttitle.setText("");
        
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String name=texttitle.getText();
        String author=textauthor.getText();
        String genere=textgenere.getText();
        Long branch=Long.parseLong(textauthors.getText());
       
        try{
           // var dto=new BookDto(name,author,genere,status,branch);
            boolean isUpdated= bookBo.update(name,author,genere,branch);
            if(isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"successfully upadated").showAndWait();
                clearFields();
            }else{
                new Alert(Alert.AlertType.ERROR,"something went wrong").showAndWait();
                 clearFields();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

       

    }
    @FXML
    void searchOnAction(ActionEvent event) {
        String name=txtsearch.getText();
        BookDto dto=bookBo.search(name);
        if(dto!=null){
            fillData(dto);
        }else{
            new Alert(Alert.AlertType.ERROR,"something went wrong").showAndWait();
            txtsearch.setText("");
        }
    }

    @FXML
    void serchKeyOnAction(KeyEvent event) {
        
       

    }

    private void fillData(BookDto dto) {
       texttitle.setText(dto.getTitle());
       textauthor.setText(dto.getAuthor());
       textauthors.setText(String.valueOf(dto.getLibraryBranch()));
       textstatus.setText(String.valueOf(dto.isAvailabilityStatus()));
       textgenere.setText(dto.getGenre());
    }
}
