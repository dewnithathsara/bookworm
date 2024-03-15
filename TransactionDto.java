package org.example.books.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.example.books.entities.Book;
import org.example.books.entities.User;



public class TransactionDto {
    private Long transactionId;
    private Long userId;
    private Long bookId;
    private String userName;

  private String branchName;
 
  private String bookname;

  private LocalDateTime borrowed;

  private LocalDate dueDate;
  private LocalDateTime returnedDate;
  private Boolean isReturn;

    public TransactionDto() {
    }

   

    public TransactionDto(Long transactionId, Long userId, Long bookId, String userName, String branchName,
            String bookname, LocalDateTime borrowed, LocalDate dueDate, LocalDateTime returnedDate, Boolean isReturn) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.bookId = bookId;
        this.userName = userName;
        this.branchName = branchName;
        this.bookname = bookname;
        this.borrowed = borrowed;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
        this.isReturn = isReturn;
    }

    public TransactionDto(Long transactionId2, Long id, String username2, String branchName2, Long bookId2,
            String title, LocalDateTime borrwDate, LocalDate due, LocalDateTime returned, Boolean isReturn2) {
        //TODO Auto-generated constructor stub
    }



    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long user) {
        this.userId = user;
    }

    public Long getBook() {
        return bookId;
    }

    public void setBook(Long book) {
        this.bookId = book;
    }



    public Long getUserId() {
        return userId;
    }



    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getBranchName() {
        return branchName;
    }



    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }



    public String getBookname() {
        return bookname;
    }



    public void setBookname(String bookname) {
        this.bookname = bookname;
    }



    public LocalDateTime getBorrowed() {
        return borrowed;
    }



    public void setBorrowed(LocalDateTime borrowed) {
        this.borrowed = borrowed;
    }



    public LocalDate getDueDate() {
        return dueDate;
    }



    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }



    public LocalDateTime getReturnedDate() {
        return returnedDate;
    }



    public void setReturnedDate(LocalDateTime returnedDate) {
        this.returnedDate = returnedDate;
    }



    public Boolean getIsReturn() {
        return isReturn;
    }



    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }



    @Override
    public String toString() {
        return "TransactionDto [transactionId=" + transactionId + ", userId=" + userId + ", bookId=" + bookId
                + ", userName=" + userName + ", branchName=" + branchName + ", bookname=" + bookname + ", borrowed="
                + borrowed + ", dueDate=" + dueDate + ", returnedDate=" + returnedDate + ", isReturn=" + isReturn + "]";
    }

}
