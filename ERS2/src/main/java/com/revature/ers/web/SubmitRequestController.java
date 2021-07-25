package com.revature.ers.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.services.LoginDao;

public class SubmitRequestController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String un=request.getParameter("username");  
	    String p=request.getParameter("userpass");
	    int id = LoginDao.getEmployeeId(un);
	    
	    LoginDao.submitReimbusementRequest(id);
	    System.out.println(id);
	    RequestDispatcher rd=request.getRequestDispatcher("/MainController");  
	    rd.forward(request,response);  
  
	          
	    out.close();  
	    }  
}
