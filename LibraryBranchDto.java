package org.example.books.dto;

public class LibraryBranchDto {
    private Long branchId;
    private String branchName;
    private String branchDetails;
    private Long books_id;
    private Long admin_id;
    
    public LibraryBranchDto() {
    }

    public LibraryBranchDto(Long branchId, String branchName, String branchDetails,Long books, Long admin) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchDetails = branchDetails;
        this.books_id = books;
        this.admin_id = admin;
    }

    public LibraryBranchDto(String branchName, String branchDetails) {
        this.branchName = branchName;
        this.branchDetails = branchDetails;
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

    public Long getBooks() {
        return books_id;
    }

    public void setBooks(Long books) {
        this.books_id = books;
    }

    public Long getAdmin() {
        return admin_id;
    }

    public void setAdmin(Long admin) {
        this.admin_id = admin;
    }

    @Override
    public String toString() {
        return "LibraryBranchDto [branchId=" + branchId + ", branchName=" + branchName + ", branchDetails="
                + branchDetails + ", books=" + books_id + ", admin=" + admin_id + "]";
    }

    
}
