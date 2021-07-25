package com.revature.ers.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.services.LoginDao;

public class WelcomeServlet extends HttpServlet {  
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {  
		  
//		    response.setContentType("text/html");  
//		    PrintWriter out = response.getWriter();  
//		          
//		    String n=request.getParameter("username");  
//		    out.print("Welcome " + LoginDao.getFullName(n) + "!");  
//		          
//		    out.close();  
		
        RequestDispatcher rd=request.getRequestDispatcher("welcome.html");  
        rd.forward(request,response); 
		    }  
		  
		}  