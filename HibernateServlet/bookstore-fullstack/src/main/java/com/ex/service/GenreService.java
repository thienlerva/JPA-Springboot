package com.ex.service;

import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.GenreDao;
import com.ex.pojo.Genre;


//REMEMBER! Biz logic(anything that's not CRUD or internet) goes here on server side
public class GenreService {
	
	static DAO<Genre, Integer> gDao = new GenreDao();
	
	public Genre addGenre(String name) {
		if(name == null) {
			return null;
		}
		else return gDao.save(new Genre(name));
	}
	
	public List<Genre> getAll() {
		
		return gDao.findAll();
	}
	
}
