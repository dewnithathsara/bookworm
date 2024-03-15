package org.example.books.bo.impl;
import org.example.books.bo.custom.*;
import org.example.books.dao.DaoFactory;
import org.example.books.dao.custom.UserDao;
import org.example.books.dto.BookDto;
import org.example.books.dto.UserDto;
import org.example.books.entities.Book;
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

    @Override
    public boolean update(String username, String email, String password) {
      User user=new User();
      user.setUsername(username);
      user.setEmailAddress(email);
      user.setPassword(password);
      
      return dao.update(user);
    }

    @Override
    public UserDto search(String userName) {
     User user= dao.search(userName);
        return new UserDto(user.getUsername(),user.getEmailAddress(),user.getPassword());
    
    }

    @Override
    public UserDto searchMybooks(String name) {
      User user= dao.search(name); 
      //user.getBooks
         return new UserDto(user.getUsername(),user.getEmailAddress(),user.getPassword());
       
    }

    @Override
    public boolean deleteUser(String name) {
      return dao.delete(name);
    } 
  }
