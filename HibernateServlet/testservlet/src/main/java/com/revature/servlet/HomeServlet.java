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



@WebServlet("/hometest")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		HttpSession session = req.getSession();
		System.out.println("doGet in home servlet");
		
		String user =  (String) session.getAttribute("user");
		System.out.println(user);
		if(user == null) {
			//redirect to login page
			resp.sendRedirect("login");
		}
		else {
			
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
			System.out.println("getRequestDis to index.html");
//			PrintWriter out = resp.getWriter();
//			resp.setContentType(user);
//			out.write(user);
			
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		String str = req.getParameter("username");
//		out.println("Welcome" + str);
	}

}
