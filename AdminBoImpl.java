package org.example.books.bo.impl;

import org.example.books.bo.custom.AdminBo;
import org.example.books.dao.DaoFactory;
import org.example.books.dao.custom.AdminDao;
import org.example.books.dto.UserDto;
import org.example.books.entities.Admin;
import org.example.books.entities.User;

public class AdminBoImpl implements AdminBo{
    AdminDao dao=(AdminDao)DaoFactory.getDaoFactory().getDaoTypes(DaoFactory.DaoTypes.ADMIN);

    @Override
    public boolean saveAdmin(String name, String email, String password) {
       Admin admin=new Admin();
       admin.setName(name);
       admin.setEmail(email);
       admin.setPassword(password);
       return dao.save(admin);
    }

    @Override
    public boolean adminLogin(UserDto dto) {
              return dao.userLogin(new User(dto.getUsername(),dto.getEmailAddress(),dto.getPassword()));

       
    }
}
