package org.example.books.dao.impl;

import org.example.books.configaration.FactoryConfiguration;
import org.example.books.dao.custom.LibraryBranchDao;
import org.example.books.entities.Book;
import org.example.books.entities.LibraryBranch;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;
import org.hibernate.query.Query;

public class LibraryDaoImpl implements LibraryBranchDao {

    @Override
    public boolean save(LibraryBranch branch) {
         Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try{
       
            System.out.println("hiiiiiiiiiiii");
            session.save(branch);
            
    
            transaction.commit();
            System.out.println(branch.toString());
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
    public boolean delete(String name) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try{
            String hql = "DELETE FROM LiberaryBranch l WHERE l.name = :branchName";
            Query query = session.createQuery(hql);
            query.setParameter("branchName", name);
            
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
    public LibraryBranch search(String name) {
      Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        String hql = "FROM LiberaryBranch l WHERE l.name = :branchName";
        Query<LibraryBranch> query = session.createQuery(hql, LibraryBranch.class);
        query.setParameter("branchName", name);
        List<LibraryBranch> results = query.getResultList();
        transaction.commit();
        session.close();
        if (!results.isEmpty()) {
            return results.get(0); 
        } else {
            return null; 
        }
    }
    @Override
    public boolean update(LibraryBranch branch) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
       try{session.save(branch);
        

        transaction.commit();
        System.out.println(branch.toString());
        return true;
       
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
        return false;
    }
    }
    
}
