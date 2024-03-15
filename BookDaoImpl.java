package org.example.books.dao.impl;

import org.example.books.configaration.FactoryConfiguration;
import org.example.books.dao.custom.BookDao;
import org.example.books.entities.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;



public class BookDaoImpl implements  BookDao{

    @Override
    public boolean save(Book book) {
         Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
       try{session.save(book);
        

        transaction.commit();
        System.out.println(book.toString());
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
    public Book search(String name) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        String hql = "FROM Book b WHERE b.title = :bookName";
        Query<Book> query = session.createQuery(hql, Book.class);
        query.setParameter("bookName", name);
        List<Book> results = query.getResultList();
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
            String hql = "DELETE FROM Book b WHERE b.title = :bookName";
            Query query = session.createQuery(hql);
            query.setParameter("bookName", name);
            
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
    public boolean update(Book book) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
       try{session.save(book);
        

        transaction.commit();
        System.out.println(book.toString());
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
    public Book get(Long bookTitle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
        
    
}
