package org.example.books.bo.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.books.bo.custom.TransactionBo;
import org.example.books.dao.DaoFactory;
import org.example.books.dao.custom.BookDao;
import org.example.books.dao.custom.TransactionDao;
import org.example.books.dao.custom.UserDao;
import org.example.books.dto.TransactionDto;
import org.example.books.entities.Book;
import org.example.books.entities.Transaction;
import org.example.books.entities.User;

public class TransactionBoImpl implements TransactionBo {
    UserDao userDao=(UserDao)DaoFactory.getDaoFactory().getDaoTypes(DaoFactory.DaoTypes.USER);
    BookDao bookDao=(BookDao)DaoFactory.getDaoFactory().getDaoTypes(DaoFactory.DaoTypes.BOOK);
    TransactionDao transactionDao=(TransactionDao)DaoFactory.getDaoFactory().getDaoTypes(DaoFactory.DaoTypes.TRANSACTION);



    @Override
    public List<TransactionDto> getUnreturned(Long userId) throws SQLException {
        // TODO Auto-generated method stub
      return null;
    }
    @Override
    public TransactionDto gettransactionBykUser(Long bookId, Long userId) throws SQLException {
        return null;
    }

    @Override
    public void saveTransaction(Long userId, String bookTitle, TransactionDto dto) throws SQLException {
       User user = userDao.getbyId(userId);
        Book book = bookDao.get(bookTitle);
        if (user!=null && book!=null){
            transactionDao.save(new Transaction(user,book,dto.getBorrowed(),dto.getDueDate(),dto.getReturnedDate()));
        }

    }

    @Override
    public boolean update(TransactionDto dto) throws SQLException {
        User user = userDao.getbyId(dto.getUserId());
        Book book = bookDao.get(dto.getBook());
        return   transactionDao.update(new Transaction(dto.getTransactionId(),user,book,dto.getBorrowed(),dto.getDueDate(),dto.getReturnedDate(),dto.getReturnedDate()));
    }

    @Override
    public List<TransactionDto> getAll() throws SQLException {
         List<TransactionDto> dtoList = new ArrayList<>();
        List<Transaction> transactions = transactionDao.getAll();
        for (Transaction transaction : transactions){
            dtoList.add(new TransactionDto(transaction.getTransactionId(), transaction.getUser().getId(),transaction.getUser().getUsername(),transaction.getBook().getLibraryBranch().getBranchName(),transaction.getBook().getBookId(),transaction.getBook().getTitle(),transaction.getBorrwDate(),transaction.getDue(),transaction.getReturned(),transaction.getIsReturn()));
        }
        return dtoList;
    }

    @Override
    public List<TransactionDto> getByUser(Long userId) throws SQLException {
        List<TransactionDto> dtoList = new ArrayList<>();
        User user = userDao.getbyId(userId);
        List<Transaction> transactions = transactionDao.getAllByUser(user);
        for (Transaction transaction : transactions){
            dtoList.add(new TransactionDto(transaction.getTransactionId(), transaction.getUser().getId(),transaction.getUser().getUsername(),transaction.getBook().getLibraryBranch().getBranchName(),transaction.getBook().getBookId(),transaction.getBook().getTitle(),transaction.getBorrwDate(),transaction.getDue(),transaction.getReturned(),transaction.getIsReturn()));
        }
        return dtoList;
    }

    @Override
    public TransactionDto search(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public List<TransactionDto> getHistory(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHistory'");
    }

    @Override
    public List<TransactionDto> getBookDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookDetails'");
    }

    @Override
    public List<TransactionDto> getMybooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMybooks'");
    }
    
}
