package org.example.books;
import org.hibernate.Session;
import org.example.books.configaration.FactoryConfiguration;
import org.hibernate.Transaction;


public class Main {
    public static void main(String args[]){
    Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        transaction.commit();
        session.close();
}
}
