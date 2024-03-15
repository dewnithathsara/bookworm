package org.example.books.dao.custom;

import org.example.books.dao.SuperDao;
import org.example.books.entities.Book;

public interface BookDao extends SuperDao {

    boolean save(Book book);

    Book search(String name);

    boolean delete(String name);

    boolean update(Book book);

    Book get(String bookTitle);

    Book get(Long book);
    
}
