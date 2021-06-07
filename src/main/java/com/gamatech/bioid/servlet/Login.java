package com.gamatech.bioid.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class Login extends HttpServlet{
	
    private static final long serialVersionUID = 1L;
    
    // This method is called by the servlet container to process a 'post' request
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleRequest(req, resp);
    }
 
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
 
        // Reading post parameters from the request
        String param1 = req.getParameter("email");
        String param2 = req.getParameter("password");
 
        // Checking for null and empty values
        if(param1 == null || param2 == null || "".equals(param1) || "".equals(param2)) {
            req.setAttribute("error_message", "Please enter email and password");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            boolean isUserFound = Util.searchUserInDb(param1, param2);
            if(isUserFound) {         
            	req.setAttribute("bcid",param1);
                req.getRequestDispatcher("/bioid.jsp").forward(req, resp);
            } else {
                req.setAttribute("error_message", "Account doesnt exist. Please register.");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }   
        }       
    }
}
