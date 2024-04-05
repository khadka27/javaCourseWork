package com.ecom.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.http.HttpSession;

import com.ecom.controller.DatabaseController;
import com.ecom.model.userModel;

//@WebServlet("/EditProfile")
//public class EditProfile extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public EditProfile() {
//		super();
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// Retrieve form parameters
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String gender = request.getParameter("gender");
////		LocalDate birthDate = LocalDate.parse(request.getParameter("birthdate"));
//	    String birthDateParam = request.getParameter("birthdate"); // Store birthdate parameter
//	    LocalDate birthDate = null; // Initialize birthDate to null
//	    
//	    // Check if birthDateParam is not null before parsing
//	    if (birthDateParam != null && !birthDateParam.isEmpty()) {
//	        birthDate = LocalDate.parse(birthDateParam);
//	    }
//		String email = request.getParameter("email");
//		String phoneNumber = request.getParameter("phoneNumber");
//		String city = request.getParameter("city");
//		String province = request.getParameter("province");
//		String country = request.getParameter("country");
//		String postalCode = request.getParameter("postalCode");
//		String userName = request.getParameter("userName");
//
//		HttpSession session = request.getSession();
//		String username = (String) session.getAttribute("userName");
//
//		// Check if the username is not null
//		if (username != null) {
//			try {
//				System.out.println("Username from session: " + username);
//
//				// Retrieve the userModel object associated with the username from the database
//				userModel user = DatabaseController.getUserByUsername(userName);
//
//				// Rest of your logic...
//				if (user != null) {
//
//					HttpSession session1 = request.getSession();
//					session1.setAttribute("firstName", firstName);
//					session1.setAttribute("lastName", lastName);
//					session1.setAttribute("userName", userName);
//					session1.setAttribute("birthDate", birthDate);
//					session1.setAttribute("email", email);
//					session1.setAttribute("phoneNumber", phoneNumber);
//					session1.setAttribute("city", city);
//					session1.setAttribute("province", province);
//					session1.setAttribute("country", country);
//					session1.setAttribute("postalCode", postalCode);
//
//					// add time on the session 30 minutes
//					session1.setMaxInactiveInterval(30 * 60);
//
//					// Update the userModel with new information
//					user.setFirstName(firstName);
//					user.setLastName(lastName);
//					user.setGender(gender);
//					user.setBirthDate(birthDate);
//					user.setEmail(email);
//					user.setPhoneNumber(phoneNumber);
//					user.setCity(city);
//					user.setProvince(province);
//					user.setCountry(country);
//					user.setPostalCode(postalCode);
//
//					// Attempt to update the user's profile
//					boolean updateSuccess = DatabaseController.updateUser(user);
//
//					if (updateSuccess) {
//						// Update successful
//						session.setAttribute("userName", userName); // Update session attribute
//						response.sendRedirect("welcome.jsp"); // Redirect to profile page
//					} else {
//						// Update failed
//						response.sendRedirect("error.jsp");
//						System.out.println("Update failed");
//					}
//				} else {
//					// Student not found in the database
//					response.sendRedirect("error.jsp");
//					System.out.println("Student not found in the database");
//				}
//			} catch (Throwable e) {
//				// Handle specific exceptions here
//				e.printStackTrace(); // Print stack trace for debugging
//				response.sendRedirect("error.jsp");
//				System.out.println("An unexpected server error occurred. ");
//			}
//		} else {
//			// Handle the case when the username is null
//			response.sendRedirect("/html/login.jsp"); // Redirect to login page
//			System.out.println("Username not found in session");
//		}
//	}
//}
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("userName");

		if (username != null) {
			try {
				// Retrieve the userModel object associated with the username from the database
				userModel user = DatabaseController.getUserByUsername(username);

				if (user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("firstName", user.getFirstName());
					session.setAttribute("lastName", user.getLastName());
					session.setAttribute("userName", user.getUserName());
					session.setAttribute("email", user.getEmail());
					session.setAttribute("phoneNumber", user.getPhoneNumber());
					session.setAttribute("city", user.getCity());
					session.setAttribute("province", user.getProvince());
					session.setAttribute("country", user.getCountry());
					session.setAttribute("postalCode", user.getPostalCode());
					session.setAttribute("gender", user.getGender());
					//add time on the session 30 minutes
					session.setMaxInactiveInterval(30 * 60);
					
					// Retrieve form parameters
					String firstName = request.getParameter("firstName");
					String lastName = request.getParameter("lastName");
					String gender = request.getParameter("gender");
					String email = request.getParameter("email");
					String phoneNumber = request.getParameter("phoneNumber");
					String city = request.getParameter("city");
					String province = request.getParameter("province");
					String country = request.getParameter("country");
					String postalCode = request.getParameter("postalCode");

					// Update the userModel with new information
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setGender(gender);
					user.setEmail(email);
					user.setPhoneNumber(phoneNumber);
					user.setCity(city);
					user.setProvince(province);
					user.setCountry(country);
					user.setPostalCode(postalCode);

					// Attempt to update the user's profile
					boolean updateSuccess = DatabaseController.updateUser(user);

					if (updateSuccess) {
						// Update successful
						request.getSession().setAttribute("user", user);
						response.sendRedirect("Profile.jsp"); // Redirect to profile page
					} else {
						// Update failed
						response.sendRedirect("error.jsp");
						System.out.println("Update failed");
					}
				} else {
					// User not found in the database
					response.sendRedirect("error.jsp");
					System.out.println("User not found in the database");
				}
			} catch (Throwable e) {
				// Handle exceptions
				e.printStackTrace();
				response.sendRedirect("error.jsp");
				System.out.println("An unexpected server error occurred.");
			}
		} else {
			// Username not found in session
			response.sendRedirect("/html/login.jsp"); // Redirect to login page
			System.out.println("Username not found in session");
		}
	}
}
