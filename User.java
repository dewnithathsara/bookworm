package org.example.books.entities;


import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class User {
 

@Id
  private String Id;
  private String name;
  private String username;
  private String emailAddress;
  private String password;
 

  public User(){

  }
  public User(String Id,String name,String username, String emailAddress,String password){
    Id=this.Id;
    name=this.name;
    username=this.username;
    emailAddress=this.emailAddress;
    password=this.password;
  }
  public String getId() {
    return Id;
  }
  public void setId(String id) {
    Id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
    return "User [Id=" + Id + ", name=" + name + ", username=" + username + ", emailAddress=" + emailAddress
        + ", password=" + password + "]";
  }
  
}
