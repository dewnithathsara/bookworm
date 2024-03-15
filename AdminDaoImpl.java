package org.example.books.dao.impl;

import java.util.List;

import org.example.books.configaration.FactoryConfiguration;
import org.example.books.dao.custom.AdminDao;
import org.example.books.entities.Admin;
import org.example.books.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AdminDaoImpl implements AdminDao{

    @Override
    public boolean save(Admin admin) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try{
        session.save(admin);
        transaction.commit();
        System.out.println(admin.toString());
        return true;
       
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
        return false;
    }
    }

    @Override
    public boolean userLogin(User user) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
       String hql = "SELECT a.email, a.password FROM Admin a WHERE a.email = :email";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("email", user.getEmailAddress()); // Assuming User class has getUsername method

            // Executing the query and retrieving the result
            List<Object[]> resultList = query.list();

            // Checking if the result is not empty
            if (!resultList.isEmpty()) {
                Object[] result = resultList.get(0);
                String email = (String) result[0];
                String password = (String) result[1];

                // Comparing retrieved password with the provided User object's password
                boolean loginSuccessful = password.equals(user.getPassword());
                 
                transaction.commit();
  
               }
               return true;
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false; // Default to false if any exception occurs
    }
    
    
}
