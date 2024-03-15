package org.example.books.controller;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.LibraryBranchBo;
import org.example.books.dto.BookDto;
import org.example.books.dto.LibraryBranchDto;
import org.example.books.entities.Admin;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LibraryBranchController {
      @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TextField txtDetails;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtadminId;

    @FXML
    private TextField txtbranchName;
    LibraryBranchBo libraryBranchBo=(LibraryBranchBo)BoFactory.getBoFactory().getBOTypes(BoFactory.botypes.LIBRARY_BRANCH);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
      String name=txtbranchName.getText();
      try{
       boolean isDeleted=libraryBranchBo.delete(name);
       if(isDeleted){
           new Alert(Alert.AlertType.CONFIRMATION,"branch deleted").show();
       }else{
           new Alert(Alert.AlertType.ERROR,"branch not deleted");
       }
   }catch(Exception e){
       new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
   }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
         String name=txtbranchName.getText();
         
         Long adminId=Long.parseLong(txtDetails.getText());
        
         try{
           boolean isSaved=libraryBranchBo.saveBranch(name);
           if(isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"successfully saved").showAndWait();
           }else{
            new Alert(Alert.AlertType.ERROR,"something went wrong").showAndWait();
           }
         }catch(Exception e){
          e.printStackTrace();
         }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
      String name=txtbranchName.getText();
      String branchDetails=txtDetails.getText();
       Long adminId=Long.parseLong(txtadminId.getText());
     
      try{
        boolean isSaved=libraryBranchBo.update(name);
        if(isSaved){
         new Alert(Alert.AlertType.CONFIRMATION,"successfully updated").showAndWait();
        }else{
         new Alert(Alert.AlertType.ERROR,"something went wrong").showAndWait();
        }
      }catch(Exception e){
       e.printStackTrace();
      }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
      String name=txtSearch.getText();
       LibraryBranchDto dto=libraryBranchBo.search(name);
        if(dto!=null){
            fillData(dto);
        }else{
            new Alert(Alert.AlertType.ERROR,"something went wrong").showAndWait();
            txtSearch.setText("");
        }
    }

    private void fillData(LibraryBranchDto dto) {
      txtbranchName.setText(dto.getBranchName());
      txtDetails.setText(dto.getBranchDetails());
      txtadminId.setText(String.valueOf(dto.getAdmin()));
      
    }
}


