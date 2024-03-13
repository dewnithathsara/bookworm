package org.example.books.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "users")
public class User {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="Id")
  private Long Id;
 @Column(name="username")
  private String username;
  @Column(name="email")
  private String emailAddress;
  @Column(name="password")
  private String password;
  @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

  public User(){

  }
  public User(String username, String emailAddress,String password){
    
    
    username=this.username;
    emailAddress=this.emailAddress;
    password=this.password;
  }
 
  
  public Long getId() {
    return Id;
  }
  public void setId(Long id) {
    Id = id;
  }
  
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getEmailAddress() {
    return emailAddress;
  }
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  @Override
  public String toString() {
    return "User [Id=" + Id + ", username=" + username + ", emailAddress=" + emailAddress + ", password=" + password
        + ", transactions=" + transactions + "]";
  }
  public List<Transaction> getTransactions() {
    return transactions;
  }
  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }
  
}

