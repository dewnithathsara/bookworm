package org.example.books.configaration;

import org.example.books.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Properties;

public class FactoryConfiguration {
private static FactoryConfiguration factoryconfiguration;
    private SessionFactory sessionFactory;
    private FactoryConfiguration() {
        try {
            Properties properties=new Properties();
            String filePath="/home/nemasha/Desktop/my program/books/src/main/resources/hibernate.properties";
            properties.load(new FileInputStream(filePath));

            Configuration config = new Configuration().addProperties(properties).addAnnotatedClass(User.class);
            sessionFactory = config.buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static FactoryConfiguration getInstance(){
        return factoryconfiguration==null? factoryconfiguration=new FactoryConfiguration(): factoryconfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
