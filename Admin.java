package org.example.books.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Admin {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long adminId;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false,unique = true)
    private String email;

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private List<LibraryBranch> branch;
    @Column(nullable = false)
    private String password;
    

    public Admin() {
        
    }


    public Admin(Long adminId, String name, String email,
            List<LibraryBranch> LibraryBranches) {
        this.adminId = adminId;
        this.name = name;
        this.email = email;
       
        this.branch = LibraryBranches;
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


   

    public List<LibraryBranch> getLibraryBranches() {
        return branch;
    }


    public void setLibraryBranches(List<LibraryBranch> LibraryBranches) {
        this.branch = LibraryBranches;
    }


    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email +  
                 ", branch=" + branch + ", password=" + password + "]";
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
    
}
