package org.example.books.dao;

import org.example.books.dao.impl.AdminDaoImpl;
import org.example.books.dao.impl.BookDaoImpl;
import org.example.books.dao.impl.LibraryDaoImpl;
import org.example.books.dao.impl.TransactionDaoImpl;
import org.example.books.dao.impl.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){

    }
    public static DaoFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory=new DaoFactory():daoFactory;
    }
    public enum DaoTypes{
        USER,TRANSACTION,BOOK,ADMIN,LIBRARY_BRANCH
    }
    public SuperDao getDaoTypes(DaoTypes daoTypes){
        switch (daoTypes){
            case USER :
                return new UserDaoImpl();
            case TRANSACTION:
                return new TransactionDaoImpl();
            case BOOK:
                return new  BookDaoImpl();
            case ADMIN:
                 return new AdminDaoImpl();
            case LIBRARY_BRANCH:
                 return new LibraryDaoImpl();           
           default:
           return null;
        }
    }
}
