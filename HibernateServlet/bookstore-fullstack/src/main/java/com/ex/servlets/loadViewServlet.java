package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class loadViewServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(loadViewServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String resourcePath = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
		
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/bookstore-fullstack/home.view":
			return "home";
		case "/bookstore-fullstack/book.view":
			return "books";
		case "/bookstore-fullstack/genre.view":
			return "genres";
		case "/bookstore-fullstack/author.view":
			return "authors";
		}
		
		return null;
	}

}
