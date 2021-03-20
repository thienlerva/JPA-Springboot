package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ex.pojo.Genre;
import com.ex.service.GenreService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/genres")
public class GenreServlet extends HttpServlet {

	
	static GenreService gService = new GenreService();
	private static Logger log = Logger.getLogger(GenreServlet.class);
	
	//get all genres method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Consult Service layer for data
		List<Genre> genres = gService.getAll();
		
		//convert to JSON
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(genres);
		log.trace("FINDING ALL GENRES. JSON: " + json);
		
		//send response
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		
		writer.write(json);
	}
	
	
	//add genres
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		ObjectMapper mapper = new ObjectMapper();
		Genre g = mapper.readValue(req.getInputStream(), Genre.class);
		g = gService.addGenre(g.getName());
		log.trace("ADDED NEW GENRE " + g);
		
	}
	
	
	
}
