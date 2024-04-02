package com.ecom.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import org.mindrot.jbcrypt.BCrypt;
import com.ecom.utils.userUtils;

import com.ecom.controller.DatabaseController;
import com.ecom.model.userModel;

//@WebServlet(asyncSupported = true, urlPatterns = { userUtils.REGISTER_SERVLET })
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DatabaseController db = new DatabaseController();

	public RegisterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String userName = request.getParameter(userUtils.USER_NAME);
		String firstName = request.getParameter(userUtils.FIRST_NAME);
		String lastName = request.getParameter(userUtils.LAST_NAME);
		String phoneNumber = request.getParameter(userUtils.PHONE_NUMBER);
		String birthdayString = request.getParameter(userUtils.BIRTHDAY);
		LocalDate birthday = LocalDate.parse(birthdayString);
		String email = request.getParameter(userUtils.EMAIL);
		String password = request.getParameter(userUtils.PASSWORD);
		String repassword = request.getParameter(userUtils.RE_PASSWORD);
		String city = request.getParameter(userUtils.CITY);
		String province = request.getParameter(userUtils.PROVINCE);
		String country = request.getParameter(userUtils.COUNTRY);
		String postalCode = request.getParameter(userUtils.POSTAL_CODE);
		String gender = request.getParameter(userUtils.GENDER);
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		userModel.setPassword(hashedPassword);

		userModel userModel = new userModel(userName, firstName, lastName, phoneNumber, birthday, email, hashedPassword,
				city, province, country, postalCode, gender);
		int result = db.addUser(userModel);

		if (result > 0) {
			response.sendRedirect(request.getContextPath() + userUtils.LOGIN_PAGE + "?" + userUtils.ERROR_MESSAGE + "="
					+ userUtils.SUCCESS_REGISTER_MESSAGE);
		} else {
			response.sendRedirect(request.getContextPath() + userUtils.REGISTER_PAGE + "?" + userUtils.ERROR_MESSAGE
					+ "=" + userUtils.REGISTER_ERROR_MESSAGE);
			System.out.println("An unexpected server error occurred. ");
		}
	}

}
