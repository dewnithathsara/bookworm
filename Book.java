package org.example.books.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class Book {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable=false)
    private String genre;

    @ManyToOne
    private LibraryBranch branch;

    @OneToMany(mappedBy = "bookList" ,cascade = CascadeType.ALL)
    private List<User> users;
    

    public Book() {
    }
    

    public Book(Long bookId, String title, String author, String genre, 
            LibraryBranch libraryBranch, List<User> users) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
     
        this.branch = libraryBranch;
        this.users = users;
    }


    public Book(String title, String author, String genre,  LibraryBranch branchId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.branch = branchId;
    }


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    

    public LibraryBranch getLibraryBranch() {
        return branch;
    }

    public void setLibraryBranch(LibraryBranch libraryBranch) {
        this.branch = libraryBranch;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", genre=" + genre + ", branch="
                + branch + ", users=" + users + "]";
    }

  
}
