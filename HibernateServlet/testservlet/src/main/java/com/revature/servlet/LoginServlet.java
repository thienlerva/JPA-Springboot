package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("doPost in login servlet--------start");
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println("doPost in middle");
		
		if(username.equalsIgnoreCase("username")) {
//			RequestDispatcher rd = req.getRequestDispatcher("home");
//			
//			rd.forward(req, resp);
			
			String uname = req.getParameter("username");
			
			HttpSession session = req.getSession();
			//create new session and returns it if none exists
			session.setAttribute("user", uname);
			
			//resp.sendRedirect("home");
			resp.sendRedirect("hometest");
		} else {
			out.println("Sorry username and password error!");
			
			RequestDispatcher rd = req.getRequestDispatcher("hello.html");
			rd.include(req, resp);
			System.out.println("doPost------------end");
		}
		
	}
}
