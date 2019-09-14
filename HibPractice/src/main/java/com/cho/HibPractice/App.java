package com.cho.HibPractice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("HibPractice");
	
    public static void main( String[] args ){
    	addUser(1, "Won Jun", "Cho");
    	addUser(2, "Donny", "Lee");
    	addUser(3, "DJ", "Kim");
    	addUser(4, "YS", "Cho");
    	
    	getUser(1);
    	getUser(2);
    	
    	System.out.println("-------------------GET ALL USER----------------------");
    	getAllUser();
    	
    	ENTITY_MANAGER_FACTORY.close();
    }
    
    public static void addUser(int id, String fName, String lName){
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	EntityTransaction et = null;
    	
    	try{
    		et = em.getTransaction();
    		et.begin();
    		User user = new User();
    		user.setId(id);
    		user.setFName(fName);
    		user.setLName(lName);
    		em.persist(user);
    		et.commit();
    		
    	}catch(Exception e){
    		if(et != null) et.rollback();
    		e.printStackTrace();
    	}finally{
    		em.close();
    	}
    }
    
    public static void getUser(int id){
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	String qry = "SELECT * FROM User where UserId = :userId";
    	TypedQuery<User> tq = em.createQuery(qry, User.class);
    	tq.setParameter("userId", id);
    	User user = null;
    	
    	try{
    		user = tq.getSingleResult();
    		user.printUser();
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		em.close();
    	}
    }
    
    public static void getAllUser(){
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	String qry = "SELECT * FROM USER";
    	TypedQuery<User> tq = em.createQuery(qry, User.class);
    	List<User> users = null;
    	
    	try{
    		users = tq.getResultList();
    		for(User user : users){
    			user.printUser();
    		}
    	}catch (Exception e){
    		e.printStackTrace();
    	} finally{
    		em.close();
    	}
    }
}
