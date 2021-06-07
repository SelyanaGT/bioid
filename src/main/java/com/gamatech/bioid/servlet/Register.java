package com.gamatech.bioid.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class Register extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;
	    
	    // This method is called by the servlet container to process a 'post' request
	    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        handleRequest(req, resp);
	    }
	 
	    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	 
	        // Reading post parameters from the request
	        String param1 = req.getParameter("email");
	        String param2 = req.getParameter("password");
	        String param3 = req.getParameter("password2");
	 
	        // Checking for null and empty values
	        if(param1 == null || param2 == null || "".equals(param1) || "".equals(param2)) {
	            req.setAttribute("error_message", "Please enter login id and password");
	            req.getRequestDispatcher("/index.jsp").forward(req, resp);
	        } else if (param2 != param3){
            	req.setAttribute("error_message", "Password doesnt matches. Please re-enter Password and Confirm Password");
	        	
	    	} else {
	            boolean isUserFound = Util.searchUserInDb(param1, param2);
	            if(isUserFound) {               
	            	req.setAttribute("error_message", "Email already exists. Please login using your credential.");
	            } else {
	            	Util.registerUserInDB(param1, param2);
	                req.setAttribute("error_message", "Registration Succesful! Please login using your credential.");
	                req.getRequestDispatcher("/index.jsp").forward(req, resp);
	            }   
	        }       
	    }
}
