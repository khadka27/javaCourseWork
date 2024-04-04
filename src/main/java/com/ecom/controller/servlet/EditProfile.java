package com.ecom.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;

import com.ecom.controller.DatabaseController;
import com.ecom.model.userModel;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditProfile() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String userName = request.getParameter("userName");

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("userName");

        // Check if the username is not null
        if (username != null) {
            try {
                System.out.println("Username from session: " + username);

                // Retrieve the userModel object associated with the username from the database
                userModel user = DatabaseController.getStudentByUsername(userName);

                // Rest of your logic...
                if (user != null) {
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
                        session.setAttribute("userName", userName); // Update session attribute
                        response.sendRedirect("welcome.jsp"); // Redirect to profile page
                    } else {
                        // Update failed
                        response.sendRedirect("error.jsp");
                        System.out.println("Update failed");
                    }
                } else {
                    // Student not found in the database
                    response.sendRedirect("error.jsp");
                    System.out.println("Student not found in the database");
                }
            } catch (Throwable e) {
                // Handle specific exceptions here
                e.printStackTrace(); // Print stack trace for debugging
                response.sendRedirect("error.jsp");
                System.out.println("An unexpected server error occurred. ");
            }
        } else {
            // Handle the case when the username is null
            response.sendRedirect("/html/login.jsp"); // Redirect to login page
            System.out.println("Username not found in session");
        }
    }
}
