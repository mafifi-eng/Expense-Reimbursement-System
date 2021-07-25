package com.revature.ers.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.services.LoginDao;

public class UpdateController extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String un=request.getParameter("username");  
	    String p=request.getParameter("userpass");
	    String oun=request.getParameter("oldUsername");
	          
	    LoginDao.updateUserInfo(oun, un, p);
	    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	    rd.forward(request,response);  
  
	          
	    out.close();  
	    }  

}
