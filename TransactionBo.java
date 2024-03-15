package org.example.books.bo.custom;

import java.sql.SQLException;
import java.util.List;

import org.example.books.bo.SuperBo;
import org.example.books.dto.BookDto;
import org.example.books.dto.TransactionDto;
import org.example.books.tm.TransactionTm;

public interface TransactionBo extends SuperBo{
     List<TransactionDto> getUnreturned(Long userId) throws SQLException;


    TransactionDto gettransactionBykUser(Long bookId, Long userId) throws SQLException;

    void saveTransaction(Long userId, String bookTitle, TransactionDto dto) throws SQLException;

    boolean update(TransactionDto dto) throws SQLException;

    List<TransactionDto> getAll() throws SQLException;

    //List<TransactionDto> getDue() throws SQLException;

    List<TransactionDto> getByUser(Long userId) throws SQLException;


    TransactionDto search(Long id);


    List<TransactionDto> getHistory(String username);


    List<TransactionDto> getBookDetails();


    List<TransactionDto> getMybooks();

   
}
