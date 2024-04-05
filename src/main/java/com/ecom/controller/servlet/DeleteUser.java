package com.ecom.controller.servlet;

import com.ecom.controller.DatabaseController;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
			// Get the user name parameter from the request
			String userName = request.getParameter("userName");
			
			// Call the method to delete the user from the database
			int deleted = DatabaseController.deleteUser(userName);
			
			if (deleted > 0) {
			    response.sendRedirect("delete-success.jsp"); // Redirect to a success page
			} else {
			    response.sendRedirect("delete-failure.jsp"); // Redirect to a failure page
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
    }
}
