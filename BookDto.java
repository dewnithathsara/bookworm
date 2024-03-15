package org.example.books.dto;

import java.util.List;

import org.example.books.dto.AdminDto;
import org.example.books.entities.LibraryBranch;

public class BookDto {
     private Long bookId;
    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus;
    private Long adminId;
    private Long libraryBranch_Id;
    private Long transactions_Id;


    
    public BookDto() {
    }



    public BookDto(Long bookId, String title, String author, String genre, boolean availabilityStatus, Long admin,
            Long libraryBranch, Long transactions) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
        this.adminId = admin;
        this.libraryBranch_Id = libraryBranch;
        this.transactions_Id = transactions;
    }



    public BookDto(String name, String author, String genere, boolean status, Long branch) {
        this.title=name;
        this.author=author;
        this.genre=genere;
        this.availabilityStatus=status;
        this.libraryBranch_Id=branch;
    }



    public BookDto(String title2, String author2, String genre2, boolean availabilityStatus2,
            LibraryBranch libraryBranch) {
        //TODO Auto-generated constructor stub
    }



    public BookDto(String title2, String author2, String genre2, LibraryBranch libraryBranch) {
        //TODO Auto-generated constructor stub
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



    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }



    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }



    public Long getAdmin() {
        return adminId;
    }



    public void setAdmin(Long admin) {
        this.adminId = admin;
    }



    public Long getLibraryBranch() {
        return libraryBranch_Id;
    }



    public void setLibraryBranch(Long libraryBranch) {
        this.libraryBranch_Id = libraryBranch;
    }



    public Long getTransactions() {
        return transactions_Id;
    }



    public void setTransactions(Long transactions) {
        this.transactions_Id = transactions;
    }



    @Override
    public String toString() {
        return "BookDto [bookId=" + bookId + ", title=" + title + ", author=" + author + ", genre=" + genre
                + ", availabilityStatus=" + availabilityStatus + ", admin=" + adminId + ", libraryBranch=" + libraryBranch_Id
                + ", transactions=" + transactions_Id + "]";
    }
    
}
