package org.example.books.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.criteria.CriteriaBuilder;
@Entity

public class LibraryBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long branchId;

    @Column(nullable = false)
    private String branchName;
    @ManyToOne
    private Admin admin;
    @Column(nullable=false)
    private String branchDetails;

    @OneToMany(mappedBy = "branch" )
    private List<Book> books;

    @OneToMany(mappedBy="branch" ) 
    private List<User> users;

    public LibraryBranch() {
    }

    public LibraryBranch(Long branchId, String branchName, Admin admin, String branchDetails, List<Book> books,
            List<User> users) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.admin = admin;
        this.branchDetails = branchDetails;
        this.books = books;
        this.users = users;
    }

    public LibraryBranch(Long branchId, String branchName, String branchDetails, List<Book> books, List<User> users) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchDetails = branchDetails;
        this.books = books;
        this.users = users;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchDetails() {
        return branchDetails;
    }

    public void setBranchDetails(String branchDetails) {
        this.branchDetails = branchDetails;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setAdmin(List<User> users) {
        this.users = users;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "LibraryBranch [branchId=" + branchId + ", branchName=" + branchName + ", admin=" + admin
                + ", branchDetails=" + branchDetails + ", books=" + books + ", users=" + users + "]";
    }
    
}

