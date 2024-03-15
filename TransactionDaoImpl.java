package org.example.books.dao.impl;

import java.util.List;

import org.example.books.configaration.FactoryConfiguration;
import org.example.books.dao.custom.TransactionDao;

import org.example.books.entities.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TransactionDaoImpl implements TransactionDao{

   

    @Override
    public List<org.example.books.entities.Transaction> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction2= session.beginTransaction();
        Query query = session.createQuery("FROM Transaction ");
        return query.getResultList();


    }

    @Override
    public List<org.example.books.entities.Transaction> getAllByUser(User user) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction2= session.beginTransaction();
        Query query = session.createQuery("from Transaction where user =:user and isReturn=:return");
        query.setParameter("user", user);
        query.setParameter("return", false);
        List<org.example.books.entities.Transaction> transactions = query.getResultList();
        return transactions;
    }

    @Override
    public void save(org.example.books.entities.Transaction transaction) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction2= session.beginTransaction();
        try{
       
            System.out.println("hiiiiiiiiiiii");
            session.save(transaction);
            
    
            transaction2.commit();
            System.out.println(transaction.toString());
           
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction2.rollback();
            }
            e.printStackTrace();
          
        }
    }

    @Override
    public boolean update(org.example.books.entities.Transaction transaction) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction2= session.beginTransaction();
        try{
        Query query = session.createQuery("update Transaction set isReturn=:return,returnedDate=:date where id=:id");
            query.setParameter("return", transaction.getIsReturn());
            query.setParameter("date", transaction.getReturned());
            query.setParameter("id", transaction.getTransactionId());
            int i = query.executeUpdate();
            System.out.println(i);
            if (i > 0) {
                transaction2.commit();
                return true;
            } 
            return true;
        }catch(Exception e){
            transaction2.rollback();
            e.printStackTrace();
            return false;
        }
    }
    
}
