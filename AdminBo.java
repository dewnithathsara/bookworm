package org.example.books.bo.custom;

import org.example.books.bo.SuperBo;
import org.example.books.dto.UserDto;

public interface AdminBo extends SuperBo{

    boolean saveAdmin(String name, String email, String password);

    boolean adminLogin(UserDto dto);
    
}
