package org.example.books.dao.impl;

import java.util.List;

import org.example.books.configaration.FactoryConfiguration;
import org.example.books.dao.custom.UserDao;
import org.example.books.entities.Book;
import org.example.books.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



public class UserDaoImpl implements UserDao{

    @Override
    public String generateUserId() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        String hql="SELECT u.Id FROM User u ORDER BY u.Id DESC";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
    
        List<String> results = query.list();
        transaction.commit();
        
    
        if (!results.isEmpty()) {
            String latestUId = results.get(0);
            int newCustomerId = Integer.parseInt(latestUId.replace("U00", "")) + 1;
            return String.format("U00%3d", newCustomerId);
        } else {
            return "U001";
        }
    }

    @Override
    public boolean saveUser(User entity) {
        System.out.println("ewwww");
      
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
       
        System.out.println("heyyyyy");
try{
       
        System.out.println("hiiiiiiiiiiii");
        session.save(entity);
        

        transaction.commit();
        System.out.println(entity.toString());
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
           
            String hql = "SELECT u.username, u.password FROM User u WHERE u.username = :username";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("username", user.getUsername()); // Assuming User class has getUsername method

            // Executing the query and retrieving the result
            List<Object[]> resultList = query.list();

            // Checking if the result is not empty
            if (!resultList.isEmpty()) {
                Object[] result = resultList.get(0);
                String username = (String) result[0];
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

    @Override
    public boolean update(User user) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try{
       
            System.out.println("hiiiiiiiiiiii");
            session.save(user);
            
    
            transaction.commit();
            System.out.println(user.toString());
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
    public User search(String userName) {
    Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        String hql = "FROM User b WHERE u.username = :userName";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("userName", userName);
        List<User> results = query.getResultList();
        transaction.commit();
        session.close();
        if (!results.isEmpty()) {
            return results.get(0); 
        } else {
            return null; 
        }
    }

    @Override
    public boolean delete(String name) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try{
            String hql = "DELETE FROM User u WHERE u.username = :userName";
            Query query = session.createQuery(hql);
            query.setParameter("userName", name);
            
            transaction.commit();
            return query.executeUpdate()>0;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return  false;
        } finally {
            session.close();
        }
    }

    @Override
    public User getbyId(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getbyId'");
    }
    }

