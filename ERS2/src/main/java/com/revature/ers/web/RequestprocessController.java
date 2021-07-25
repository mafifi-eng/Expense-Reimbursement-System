package com.revature.ers.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.RequestEntity;
import com.revature.ers.services.LoginDao;

public class RequestprocessController extends HttpServlet {
	
    // /api/test
    // /api/test?name="..."
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper om = new ObjectMapper();
        String responseText = "";
        if(req.getParameterMap().containsKey("status") && req.getParameterMap().containsKey("requestId")) {
            String status = req.getParameter("status");
            String requestId = req.getParameter("requestId");
    		LoginDao.setRequestStatus(requestId, status);
        } 
        responseText = om.writeValueAsString(null);
        resp.setContentType("application/json");
        resp.setStatus(200);
        resp.getWriter().write(responseText.toString());
        
        RequestDispatcher rd=req.getRequestDispatcher("/MainController");  
        rd.forward(req,resp); 
    }

}
