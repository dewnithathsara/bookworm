package org.example.books.bo;

import org.example.books.bo.impl.AdminBoImpl;
import org.example.books.bo.impl.BookBoImpl;
import org.example.books.bo.impl.LibraryBoImpl;
import org.example.books.bo.impl.TransactionBoImpl;
import org.example.books.bo.impl.UserBoImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){

    }
    public static BoFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BoFactory():boFactory;
    }
    public enum botypes{
       USER,ADMIN,BOOK,LIBRARY_BRANCH,TRANSACTION

    }
    public SuperBo getBOTypes(BoFactory.botypes Botypes){
        switch (Botypes){
            case USER :
                return new UserBoImpl();
            case ADMIN:
                return new AdminBoImpl();
            case BOOK:
                return new   BookBoImpl();
            case LIBRARY_BRANCH:
                return new LibraryBoImpl();
            case  TRANSACTION:
                return new TransactionBoImpl();
           default:
           return null;
        }
    }
    
}
