package org.example.books.tm;

public class BookTm {
    private Long id;
    
    private String bookName;
    private String author;
    public BookTm() {
    }
    public BookTm(Long id, String bookName, String author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "BookTm [id=" + id + ", bookName=" + bookName + ", author=" + author + "]";
    }


    
}
