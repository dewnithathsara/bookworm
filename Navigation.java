package org.example.books.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Navigation {
     public static AnchorPane pane;

    public static void navigate(Route route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();
        switch (route) {
            case SIGNUP:
                window.setTitle("Signup Form");
                initUI("signUp.fxml");
                break;
            case LOGIN:
                window.setTitle("Login Form");
                initUI("login.fxml");
                break;
            case WELCOME:
                window.setTitle("Welcome");
                initUI("hello-view.fxml");
                break;
                case SIDEPANEL:
                window.setTitle("SidePanel");
                initUI("sidePanel.fxml");
                break;
                case USER:
                window.setTitle("Users");
                initUI("user.fxml");
                break;
                case ADMINLOGIN:
                window.setTitle("admin login");
                initUI("adminLogin.fxml");
                break;
                case ADMINSIGNUP:
                window.setTitle("admin Sign Up");
                initUI("adminSignUp.fxml");
                break;
                case ADMIN:
                window.setTitle("Admin");
                initUI("admin.fxml");
                break;
                case BOOK:
                window.setTitle("Book");
                initUI("book.fxml");
                break;
                case LIBRARYBRANCH:
                window.setTitle("Library branch");
                initUI("libraryBranch.fxml");
                break;
                default:
                System.out.println("Mukuth Natho");
        }
    }
        public static void initUI(String location) throws IOException {
            Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/org/example/books/" + location)));
        }
    }

