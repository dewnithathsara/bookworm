package org.example.books.bo.impl;
import org.example.books.bo.custom.*;
import org.example.books.dao.DaoFactory;
import org.example.books.dao.custom.UserDao;
import org.example.books.dto.UserDto;
import org.example.books.entities.User;
//import org.hibernate.Transaction;

public class UserBoImpl implements UserBo{
    UserDao dao=(UserDao)DaoFactory.getDaoFactory().getDaoTypes(DaoFactory.DaoTypes.USER);

    @Override
    public String generateUserId() {
      return dao.generateUserId();
    }

    @Override
    public boolean saveUser(String username,String email, String password) {
      System.out.println("weeeee");
      User user=new User();
      user.setUsername(username);
      user.setEmailAddress(email);
      user.setPassword(password);
      
      return dao.saveUser(user);
    }

    @Override
    public boolean login(UserDto dto) {
      return dao.userLogin(new User(dto.getUsername(),dto.getEmailAddress(),dto.getPassword()));
    } 
  }
