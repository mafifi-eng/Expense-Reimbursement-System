package com.revature.ers.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.Employee;
import com.revature.ers.services.LoginDao;

public class WebServlet extends HttpServlet {
	
    // /api/test
    // /api/test?name="..."
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper om = new ObjectMapper();
        String responseText = "";
        LoginDao dao = new LoginDao();
        if(req.getParameterMap().containsKey("username")) {
            String username = req.getParameter("username");
            Employee emp = dao.getEmplyeeDetails(username);
            responseText = om.writeValueAsString(Arrays.asList(emp));
            System.out.println(emp.getName());
        }
        
        resp.setContentType("application/json");
        resp.setStatus(200);
        resp.getWriter().write(responseText.toString());
    }

}
