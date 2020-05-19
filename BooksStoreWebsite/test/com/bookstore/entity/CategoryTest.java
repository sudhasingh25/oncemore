package com.bookstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Category;

public class CategoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Category newCat=new Category("core java");
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BooksStoreWebsite");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(newCat);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println(" a user object is persisted");
	
	}

}
