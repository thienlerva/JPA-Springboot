package com.revature.app;

import java.util.List;

import com.revature.dao.PostDao;
import com.revature.dao.UserDao;
import com.revature.models.Post;
import com.revature.models.User;

public class Main {

	static UserDao dao = new UserDao();
	static PostDao postDao = new PostDao();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//addPostToUser(52, "Hibernate is aswome", "Today i learn so mucha");
		
		List<User> users = dao.findAll();
		for(User user : users) {
			System.out.println(user);
		}
		
		
		
	}
	
	static void testingMultiplicity() {
		
		User u = new User("post", "post", "post", "post");
		Post p = new Post("subject", "body", u);
		p = postDao.save(p);
		System.out.println(p);
	}
	
	static void addPostToUser(int userId, String subject, String body) {
		
		User u = dao.getById(userId);
		Post p = new Post(subject, body, u);
		postDao.save(p);
		
	}
	
	static void testingRead() {
		
		
		List<User> users = dao.findAll();
		for(User user : users) {
			System.out.println(user);
		}
		
		//RETRIEVING USER
	User u50 = dao.getById(50);
	System.out.println("Retreiving user of id 50 with GET");
	System.out.println(u50.toString());
	
	User u50load = dao.loadById(51);
	System.out.println("Retreiving user of id 50 with LOAD");
	System.out.println(u50load.toString());
	}
	
	static void testingCreate() {
		//Saving user
		
		User u1 = new User("username", "password", "firstname", "lastname");
		User u2 = new User("gb123", "123", "Gen", "Bonds");
		User u3 = new User("testuser", "abc", "Test", "User");

		dao.save(u1);
		dao.save(u2);
		dao.save(u3);
	}

}
