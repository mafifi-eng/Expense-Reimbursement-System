package com.revature.ers.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.Employee;
import com.revature.ers.models.RequestEntity;
import com.revature.ers.services.LoginDao;

public class RequestWebService extends HttpServlet {

    // /api/test
    // /api/test?name="..."
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper om = new ObjectMapper();
        String responseText = "";
        if(req.getParameterMap().containsKey("username")) {
            String username = req.getParameter("username");
    		List<RequestEntity> list = LoginDao.getRequestsByEmployee(username);
    		responseText = om.writeValueAsString(list);
        } else {
        	String username = req.getParameter("username");
    		List<RequestEntity> list = LoginDao.getAllRequest(username);
    		responseText = om.writeValueAsString(list); 
        }
        
        resp.setContentType("application/json");
        resp.setStatus(200);
        resp.getWriter().write(responseText.toString());
    }
}
