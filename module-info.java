module org.example.books {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
     
  
    opens org.example.books.entities to org.hibernate.orm.core;
    opens org.example.books to javafx.fxml;
    exports org.example.books;
}