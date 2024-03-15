package org.example.books.bo.impl;

import org.example.books.bo.BoFactory;
import org.example.books.bo.custom.BookBo;
import org.example.books.dao.DaoFactory;
import org.example.books.dao.custom.BookDao;
import org.example.books.dto.BookDto;
import org.example.books.dto.LibraryBranchDto;
import org.example.books.entities.Book;

public class BookBoImpl implements BookBo {
BookDao dao=(BookDao)DaoFactory.getDaoFactory().getDaoTypes(DaoFactory.DaoTypes.BOOK);
    @Override
    public boolean save(String name, String author, String genere, Long branch) {
        Book book=new Book();
        book.setTitle(name);
        book.setAuthor(author);
        book.setGenre(genere);
        book.getLibraryBranch();
        return dao.save(book);
    }
    
    @Override
    public BookDto search(String name) {
        Book book= dao.search(name);
        return new BookDto(book.getTitle(),book.getAuthor(),book.getGenre(),book.getLibraryBranch());
    }

    @Override
    public boolean delete(String name) {
       return dao.delete(name);
    }

    @Override
    public boolean update(String name, String author, String genere,  Long branch) {
        Book book=new Book();
        book.setTitle(name);
        book.setAuthor(author);
        book.setGenre(genere);
       
        book.getLibraryBranch();
        return dao.update(book);
    }
    
}
