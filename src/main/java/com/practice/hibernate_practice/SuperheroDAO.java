package com.practice.hibernate_practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

public class SuperheroDAO {
	
	private SessionFactory factory;
	private Session session;
	
    public SuperheroDAO() {
    	try {
    		
        	// Load .env file
        	Dotenv dotenv = Dotenv.load();
        	
        	// Access values from .env file
            String dbUrl = dotenv.get("DATABASE_URL");
            String dbUser = dotenv.get("DATABASE_USER");
            String dbPassword = dotenv.get("DATABASE_PASSWORD");
            
            // Set up Hibernate configuration
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            
            config.addAnnotatedClass(com.practice.hibernate_practice.Superhero.class);
            
            // Configure database connection dynamically
            config.setProperty("hibernate.connection.url", dbUrl);
            config.setProperty("hibernate.connection.username", dbUser);
            config.setProperty("hibernate.connection.password", dbPassword);
            
            factory = config.buildSessionFactory();
            session = factory.openSession();
    	}catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public void saveSuperhero(Superhero superhero) {
        session.beginTransaction();
        session.persist(superhero);
        session.getTransaction().commit();
    }
    
    public Superhero getSuperhero(int id) {
        //session = factory.getCurrentSession();
        return session.find(Superhero.class, id);
    }
    
    public List<Superhero> getAllSuperheroes() {
        Session session = factory.getCurrentSession();
        return session.createQuery("from Superhero", Superhero.class).getResultList();
    }
    
    public void close() {
        factory.close();
        session.close();
    }

}
