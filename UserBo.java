package org.example.books.bo.custom;
import org.example.books.bo.SuperBo;
import org.example.books.dto.UserDto;

public interface UserBo extends SuperBo{

    String generateUserId();

    boolean saveUser(String username,String email,String password);

    boolean login(UserDto dto);
    
}
