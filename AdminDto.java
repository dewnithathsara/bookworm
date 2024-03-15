package org.example.books.dto;

//import java.util.List;

public class AdminDto {
    private Long adminId;
  
    private String name;
   
    private String email;
    private String password;
   
    private String book;
    private Long branchId;

    public AdminDto() {
    }


    public AdminDto(Long adminId, String name, String email, String book,
            Long branchId, String password) {
        this.adminId = adminId;
        this.name = name;
        this.email = email;
        this.book = book;
        this.branchId = branchId;
        this.password=password;
    }

    public AdminDto(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public Long getAdminId() {
        return adminId;
    }


    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getBooks() {
        return book;
    }


    public void setBooks( String Books) {
        this.book = Books;
    }


    public Long getLibraryBranches() {
        return branchId;
    }


    public void setLibraryBranches(Long branchId) {
        this.branchId = branchId;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

}
