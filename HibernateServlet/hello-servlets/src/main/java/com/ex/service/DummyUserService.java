package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class DummyUserService {
	
	/*
	 * Dummy service layer with an in memory store of users
	 */
	
	static ArrayList<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("Genesis", "123", "Genesis is awesome"));
		users.add(new User("test", "user", "testing servlet capabilities"));
		users.add(new User("anotherUser", "user", "three for good measure"));
	}
	
	//get all users
	public ArrayList<User> getUsers(){
		
		return users;
	}
	
	//get by username
	private User getByUsername(String name) {
		//working with streams!
		
		/*//could do enhanced for loop....
		for(User u : users) {
			if(u.getUsername().equals(name)) return u;
		} */
		
		//OR USE REALLY COMPLEX STREAMS 
		User u = users.stream() //turns users into a stream
				.filter( x -> x.getUsername().equalsIgnoreCase(name)) //test from Predicate F.I.	
				.findAny()
				.orElse(null);
		
		return u;
	}
	
	
	//validate password by username
	public User validateUser(String name, String password) {
		User u = getByUsername(name);
		if(u == null) return null;
		else if(u.getPassword().equals(password)) return u; //only case where user is logged in 
		else {
			return null;
		}
	}

}
