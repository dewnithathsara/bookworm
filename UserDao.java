package org.example.books.dao.custom;

import org.example.books.dao.SuperDao;
import org.example.books.entities.User;

public interface UserDao extends SuperDao{

    String generateUserId();

    boolean saveUser(User entity);

    boolean userLogin(User user);

    boolean update(User user);

    User search(String userName);

    boolean delete(String name);

    User getbyId(Long userId);
    
}
