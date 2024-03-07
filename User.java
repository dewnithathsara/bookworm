package org.example.books.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class User {
@Id
  private String Id;
  private String title;
  private String author;

}
