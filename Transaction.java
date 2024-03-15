package org.example.books.entities;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Transaction {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

   
    private  LocalDateTime borrwDate;
    private LocalDate due;
    private LocalDateTime returned;
    private Boolean isReturn;

    public Transaction() {
    }

    

    public Transaction(Long transactionId, User user, Book book, LocalDateTime borrwDate, LocalDate due,
            LocalDateTime returned, Boolean isReturn) {
        this.transactionId = transactionId;
        this.user = user;
        this.book = book;
        this.borrwDate = borrwDate;
        this.due = due;
        this.returned = returned;
        this.isReturn = isReturn;
    }



    public Transaction(User user2, Book book2, LocalDateTime borrowed, LocalDate dueDate, LocalDateTime returnedDate) {
        //TODO Auto-generated constructor stub
    }



    public Transaction(Long transactionId2, User user2, Book book2, LocalDateTime borrowed, LocalDate dueDate,
            LocalDateTime returnedDate, LocalDateTime returnedDate2) {
        //TODO Auto-generated constructor stub
    }



    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    
    public LocalDateTime getBorrwDate() {
        return borrwDate;
    }



    public void setBorrwDate(LocalDateTime borrwDate) {
        this.borrwDate = borrwDate;
    }



    public LocalDate getDue() {
        return due;
    }



    public void setDue(LocalDate due) {
        this.due = due;
    }



    public LocalDateTime getReturned() {
        return returned;
    }



    public void setReturned(LocalDateTime returned) {
        this.returned = returned;
    }



    public Boolean getIsReturn() {
        return isReturn;
    }



    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }



    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", user=" + user + ", book=" + book + ", borrwDate="
                + borrwDate + ", due=" + due + ", returned=" + returned + ", isReturn=" + isReturn + "]";
    }



    
}
