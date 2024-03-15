package org.example.books.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class User {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long Id;
 @Column(nullable =false)
  private String username;
  @Column(nullable=false)
  private String emailAddress;
  @Column(nullable = false)
  private String password;
  @ManyToOne
  private LibraryBranch branch;

 @ManyToMany
    @JoinTable(
            name = "Transaction",
           joinColumns =  @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "bookId")
    )
    private List<Book> bookList;
   // @OneToMany(mappedBy="library_branch")
   // private List<LibraryBranch> libraryBranchs;

  public User(){

  }
  public User(String username, String emailAddress,String password){
    
    
    username=this.username;
    emailAddress=this.emailAddress;
    password=this.password;
  }
 
  
  public User(Long id, String username, String emailAddress, String password, LibraryBranch branch,
      List<Book> bookList) {
    Id = id;
    this.username = username;
    this.emailAddress = emailAddress;
    this.password = password;
    this.branch = branch;
    this.bookList = bookList;
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
  
  public LibraryBranch getBranch() {
    return branch;
  }
  public void setBranch(LibraryBranch branch) {
    this.branch = branch;
  }
  public List<Book> getBookList() {
    return bookList;
  }
  public void setBookList(List<Book> bookList) {
    this.bookList = bookList;
  }
  @Override
  public String toString() {
    return "User [Id=" + Id + ", username=" + username + ", emailAddress=" + emailAddress + ", password=" + password
        + ", branch=" + branch + ", bookList=" + bookList + "]";
  }
}
