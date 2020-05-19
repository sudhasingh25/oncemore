package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest extends BaseDAOTest{

		
	private static UserDAO userDAO;
		
	@BeforeClass
	public static void setupClass() throws Exception{
		BaseDAOTest.setUpBeforeClass();
		userDAO=new UserDAO(entityManager);
	}
	@Test
	public void testCreateUsers() {
		Users user1=new Users();
		user1.setEmail("shalu@gmail.com");
		user1.setFullName("shalu moore");
		user1.setPassword("shalu123");
		
	   
		user1=userDAO.create(user1);
		assertTrue(user1.getUserId()>0);
	}
	
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1=new Users();
		user1=userDAO.create(user1);
		//assertTrue(user1.getUserId()>0);
	}
	
	@Test
	public void testUpdateUsers(){
		Users user=new Users();
		user.setUserId(1);
		user.setEmail("mymail123@gmail.com");
		user.setFullName("mine");
		user.setPassword("mine123");
		
		user=userDAO.update(user);
		String expected="mine123";
		String actual=user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsersFound(){
		Integer userId=1;
		Users user=userDAO.get(userId);
		if(user != null){
			System.out.println(user.getEmail());
		}
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound(){
		Integer userId=99;
		Users user=userDAO.get(userId);
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers(){
		Integer userId=4;
		userDAO.delete(userId);
		Users user=userDAO.get(userId);

		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers(){
		Integer userId=55;
		userDAO.delete(userId);
	}
	
	@Test
	public void testCount(){
		long totalUsers = userDAO.count();
		assertEquals(4, totalUsers);
	}
	
	@Test
	public void testListAll(){
		List<Users> listUsers= userDAO.listAll();
		for(Users user:listUsers)
		{
			System.out.println(user.getEmail());
		}
		assertTrue(listUsers.size()>0);
	}
	
	@Test
	public void testFindByEmail(){
		String email="sudha123@gmail.com";
		Users user=userDAO.findByEmail(email);
		assertNotNull(user);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

}
