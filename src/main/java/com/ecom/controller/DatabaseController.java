/**
 * 
 */
package com.ecom.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecom.model.userModel;
import com.ecom.utils.stringUtils;

/**
 * 
 */
public class DatabaseController {
	public static Connection getConn() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = ("jdbc:mysql://localhost:3306/coursework");
		String username = "root";
		String password = "";
		System.out.println("Connected to database");
		return DriverManager.getConnection(url, username, password);
	}
	
	public int addUser(userModel userModel) {
		try (Connection conn = getConn()) {
			PreparedStatement ps = conn.prepareStatement(stringUtils.Insert_User);

			ps.setString(1, userModel.getUserName());
			ps.setString(2, userModel.getFirstName());
			ps.setString(3, userModel.getLastName());
			ps.setString(4, userModel.getPhoneNumber());
			ps.setDate(5, java.sql.Date.valueOf(userModel.getBirthday())); // Correct index for birthday
			ps.setString(6, userModel.getEmail());
			ps.setString(7, userModel.getPassword());
			ps.setString(8, userModel.getCity());
			ps.setString(9, userModel.getProvince());
			ps.setString(10, userModel.getCountry());
			ps.setString(11, userModel.getPostalCode());
			ps.setString(12, userModel.getGender());
			
			int i = ps.executeUpdate();
			return i;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
		
		
	}
	public int getStudentLoginInfo(String userName, String password) {
		try (Connection con = getConn()) {
			PreparedStatement ps = con.prepareStatement(stringUtils.GET_LOGIN_USER_INFOS);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// User name and password match in the database
				return 1;
			} else {
				// No matching record found
				return 0;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;

		}
	}
	
	public String getHashedPassword(String userName) {
		try (Connection con = getConn()) {
			PreparedStatement st = con.prepareStatement(stringUtils.GET_HASHED_PASSWORD);
			st.setString(1, userName);
			ResultSet rs = st.executeQuery();
			/*
			 * String password = rs.getString("hashed_password"); System.out.println(
			 * password);
			 */
			if (rs.next()) {
				return rs.getString("password");
			} else {
				// Username not found
				return null;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}


}
