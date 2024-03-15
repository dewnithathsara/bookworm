package org.example.books.dao.custom;

import org.example.books.dao.SuperDao;
import org.example.books.entities.Admin;
import org.example.books.entities.User;

public interface AdminDao extends SuperDao {

    boolean save(Admin admin);

    boolean userLogin(User user);
    
}
