package org.example.books.tm;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionTm {
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




  
public TransactionTm(String bookname, LocalDateTime borrowed, LocalDateTime returnedDate) {
    this.bookname = bookname;
    this.borrowed = borrowed;
    this.returnedDate = returnedDate;
}





public TransactionTm(String bookname, LocalDate dueDate) {
    this.bookname = bookname;
    this.dueDate = dueDate;
}





public TransactionTm(Long transactionId, Long userId, Long bookId, String userName, String branchName, String bookname,
        LocalDateTime borrowed, LocalDate dueDate, LocalDateTime returnedDate, Boolean isReturn) {
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





@Override
public String toString() {
    return "TransactionTm [transactionId=" + transactionId + ", userId=" + userId + ", bookId=" + bookId + ", userName="
            + userName + ", branchName=" + branchName + ", bookname=" + bookname + ", borrowed=" + borrowed
            + ", dueDate=" + dueDate + ", returnedDate=" + returnedDate + ", isReturn=" + isReturn + "]";
}





public Long getTransactionId() {
    return transactionId;
}





public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
}





public Long getUserId() {
    return userId;
}





public void setUserId(Long userId) {
    this.userId = userId;
}





public Long getBookId() {
    return bookId;
}





public void setBookId(Long bookId) {
    this.bookId = bookId;
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


}
