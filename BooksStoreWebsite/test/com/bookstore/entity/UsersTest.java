package com.bookstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UsersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Users user1=new Users();
		user1.setEmail("ram25@gmail.com");
		user1.setFullName("Ram Singh Sengar");
		user1.setPassword("ram123singh");
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BooksStoreWebsite");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(user1);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(" a user object is persisted");
	
	}

}
