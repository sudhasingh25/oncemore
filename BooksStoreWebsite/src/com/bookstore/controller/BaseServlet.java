package com.bookstore.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/")
public abstract class BaseServlet extends HttpServlet {
	
	protected EntityManager entityManager;
	protected EntityManagerFactory entityManagerFactory;
	

	@Override
	public void init() throws ServletException {
		entityManagerFactory = Persistence.createEntityManagerFactory("BooksStoreWebsite");
		entityManager=entityManagerFactory.createEntityManager();
	}
	
	@Override
	public void destroy() {
		entityManager.close();
		entityManagerFactory.close();
	}


	private static final long serialVersionUID = 1L;

}
