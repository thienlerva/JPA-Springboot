package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ex.pojos.User;
import com.ex.service.DummyUserService;

/*
 * The following annotation eliminates the need for registering
 * the class as a servlet in the web.xml.
 * The servlet takes parameters as well such as load on startup etc
 * If you do not add any parameters, you can simply add the 
 * url-pattern without a param name in the parenthesis 
 * 
 * Note: do NOT use this AND the xml for the same servlet
 * you can use both for different servlets in the same app. but do not 
 * assign more than one url-pattern to the same servlet 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	static DummyUserService userService = new DummyUserService();
	private static Logger logger = Logger.getLogger(LoginServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// functionality to go back to login.html 
		//REQUEST DISPATCHER
		req.getRequestDispatcher("login.html").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//login functionality here:
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//consult user service to obtain User with this info
		User user = userService.validateUser(username, password); 
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "";
		
		if(user == null) {
			
			req.getRequestDispatcher("error-login.html").forward(req, resp);
		}
		else {
			//successful log in 
			
			
			//Add user to session
			HttpSession session = req.getSession();
			//will return current session if one exists
			//create new session and returns it if none exists
			session.setAttribute("user", user);
			logger.trace("ADDING USER TO SESSION: " + session.getId());
			
			resp.sendRedirect("home");
			//render home view
			//redirect to home servlet

		}
		
	}

}
