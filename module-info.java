module org.example.books {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires org.controlsfx.controls;
    //requires mysql.connector.j;
     
  
    opens org.example.books.entities to org.hibernate.orm.core;
    opens org.example.books.controller to javafx.fxml;
    opens org.example.books to javafx.fxml;
    exports org.example.books;
    exports org.example.books.controller;
}