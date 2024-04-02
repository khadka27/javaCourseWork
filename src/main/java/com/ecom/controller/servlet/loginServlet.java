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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String userName = request.getParameter(userUtils.USER_NAME);
//		String password = request.getParameter(userUtils.PASSWORD);
//		String hashedPasswordDB = db.getHashedPassword(userName);
//		System.out.println("Hashed Password: " + hashedPasswordDB);
//		if (hashedPasswordDB != null && hashedPasswordDB.contains("$")) {
//			String[] parts = hashedPasswordDB.split("\\$");
//			String extractedSalt = parts[2];
//			String extractedHash = parts[3];
//
//			String hashedPasswordSalt = "$2a$" + extractedSalt + "$" + extractedHash;
//
//			if (BCrypt.checkpw(password, hashedPasswordSalt)) {
//				
//				  int loginResult = db.getStudentLoginInfo(userName, hashedPasswordSalt);
//				 if (loginResult == 1) {
//				 
//				// Successful login
////				HttpSession session = request.getSession();
////
////				session.setAttribute("username", userName);
////				session.setMaxInactiveInterval(30 * 60);// Storing username in session
//				response.sendRedirect(request.getContextPath() + userUtils.WELCOME_PAGE);
//
//			} else {
//
//				request.setAttribute("errorMessage", "Incorrect username or password");
//				RequestDispatcher dispatcher = request.getRequestDispatcher(userUtils.WELCOME_PAGE);
//
//				dispatcher.forward(request, response);
////		            request.getRequestDispatcher(studentUtils.LOGIN_PAGE).forward(request, response);
//				/*
//				 * } else { response.sendRedirect("login.jsp?error=true"); } //
//				 */
//			}
//			}
//			
//
//	}
//	}
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
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
	            int loginResult = db.getStudentLoginInfo(userName, hashedPasswordSalt);
	            if (loginResult == 1) {
	                // Successful login
	                HttpSession session = request.getSession();

	                session.setAttribute("username", userName);
	                session.setMaxInactiveInterval(30 * 60); // Storing username in session
	                response.sendRedirect(request.getContextPath() + userUtils.WELCOME_PAGE);
	            } else {
	                // Incorrect username or password
	                request.setAttribute("errorMessage", "Incorrect username or password");
	                RequestDispatcher dispatcher = request.getRequestDispatcher(userUtils.LOGIN_PAGE);
	                dispatcher.forward(request, response);
	            }
	        } else {
	            // Incorrect username or password
	            request.setAttribute("errorMessage", "Incorrect username or password");
	            RequestDispatcher dispatcher = request.getRequestDispatcher(userUtils.LOGIN_PAGE);
	            dispatcher.forward(request, response);
	        }
	    } else {
	        // Incorrect username or password
	        request.setAttribute("errorMessage", "Incorrect username or password");
	        RequestDispatcher dispatcher = request.getRequestDispatcher(userUtils.LOGIN_PAGE);
	        dispatcher.forward(request, response);
	    }
	}
}

