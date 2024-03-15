package org.example.books.bo.custom;

import java.sql.SQLException;
import java.util.List;

import org.example.books.bo.SuperBo;
import org.example.books.dto.TransactionDto;

public interface TransactionBo extends SuperBo{
     List<TransactionDto> getUnreturned(Long userId) throws SQLException;


    TransactionDto gettransactionBykUser(Long bookId, Long userId) throws SQLException;

    boolean saveTransaction(Long userId, Long bookTitle, TransactionDto dto) throws SQLException;

    boolean update(TransactionDto dto) throws SQLException;

    List<TransactionDto> getAll() throws SQLException;

    List<TransactionDto> getOverDue() throws SQLException;

    List<TransactionDto> getByUser(Long userId) throws SQLException;

   
}
