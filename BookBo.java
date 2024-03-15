package org.example.books.bo.custom;

import java.util.List;

import org.example.books.bo.SuperBo;
import org.example.books.dto.BookDto;

public interface BookBo extends SuperBo {

    boolean save(String name, String author, String genere, Long branch);

    //boolean save(BookDto dto);

    BookDto search(String name);

    boolean delete(String name);

    boolean update(String name, String author, String genere, Long branch);

    List<BookDto> getBookDetails();

    
}
