package com.ecom.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.ecom.controller.DatabaseController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

import com.ecom.utils.userUtils;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	DatabaseController db = new DatabaseController();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String userName = request.getParameter(userUtils.USER_NAME);
	    String password = request.getParameter(userUtils.PASSWORD);
	    String hashedPasswordDB = db.getHashedPassword(userName);
	    System.out.println("Hashed Password: " + hashedPasswordDB);
	    if (hashedPasswordDB != null && hashedPasswordDB.contains("$")) {
	        String[] parts = hashedPasswordDB.split("\\$");
	        String extractedSalt = parts[2];
	        String extractedHash = parts[3];

	        String hashedPasswordSalt = "$2a$" + extractedSalt + "$" + extractedHash;

	        if (BCrypt.checkpw(password, hashedPasswordSalt)) {
	            int loginResult = db.getUserLoginInfo(userName, hashedPasswordSalt); // Assuming separate method for user login
	            if (loginResult == 1) {
	                // Successful user login
	                HttpSession session = request.getSession();
	                session.setAttribute("userName", userName);
	                session.setAttribute("role", "user"); // Set user role in session
	                session.setMaxInactiveInterval(30 * 60);
	                response.sendRedirect(request.getContextPath() + userUtils.WELCOME_PAGE); // Redirect to user welcome page
	            } else {
	            	
	                // Check admin login
	                loginResult = db.getAdminLoginInfo(userName, hashedPasswordSalt); // Assuming separate method for admin login
	                if (loginResult == 1) {
	                    // Successful admin login
	                    HttpSession session = request.getSession();
	                    session.setAttribute("userName", userName);
	                    session.setAttribute("role", "admin"); // Set admin role in session
	                    session.setMaxInactiveInterval(30 * 60);
	                    response.sendRedirect(request.getContextPath() + userUtils.ADMIN_PAGE); // Redirect to admin welcome page
	                } else {
	                    // Incorrect username or password for both user and admin
	                    request.setAttribute("errorMessage", "Incorrect username or password");
	                    RequestDispatcher dispatcher = request.getRequestDispatcher(userUtils.LOGIN_PAGE);
	                    dispatcher.forward(request, response);
	                }
	            }
	        } else {
	            // Incorrect username or password
	            request.setAttribute("errorMessage", "Incorrect username or password");
	            RequestDispatcher dispatcher = request.getRequestDispatcher(userUtils.LOGIN_PAGE);
	            dispatcher.forward(request, response);
	        }
	        
	    }
	  }
	
}

