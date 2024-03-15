package org.example.books.dto;

public class UserDto {
    
   
    private String username;
    private String emailAddress;
    private String password;
    private Long branchId;
   
  
    public UserDto(){
  
    }
    public UserDto(String username, String emailAddress,String password){
     
      
      username=this.username;
      emailAddress=this.emailAddress;
      password=this.password;
    }
   
   
    public UserDto(String username, String emailAddress, String password, Long branchId) {
      this.username = username;
      this.emailAddress = emailAddress;
      this.password = password;
      this.branchId = branchId;
    }
    public UserDto(String username, String password) {
      this.username = username;
      this.password = password;
    }
    public String getUsername() {
      return username;
    }
    public void setUsername(String username) {
      this.username = username;
    }
    public String getEmailAddress() {
      return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
    }
    public String getPassword() {
      return password;
    }
    public void setPassword(String password) {
      this.password = password;
    }


    
    public Long  getLibraryBranch() {
      return branchId;
    }
    public void setLibraryBranch(Long branchId) {
      this.branchId = branchId;
    }
    @Override
    public String toString() {
      return "User [username=" + username + ", emailAddress=" + emailAddress
          + ", password=" + password + "]";
    }
    
}
