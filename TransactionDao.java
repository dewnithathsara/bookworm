package org.example.books.dao.custom;

import java.util.List;

import org.example.books.dao.SuperDao;
import org.example.books.entities.Transaction;
import org.example.books.entities.User;

public interface TransactionDao extends SuperDao {

    void save(Transaction transaction);

    boolean update(Transaction transaction);

    List<Transaction> getAll();

    List<Transaction> getAllByUser(User user);
    
}
