/**
 * 
 */
package com.ecom.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.lang.model.util.Types;

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
	
	//user login info
	public int getUserLoginInfo(String userName, String password) {
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
	
	// admin login info
	public int getAdminLoginInfo(String userName, String password) {
		try (Connection con = getConn()) {
			PreparedStatement ps = con.prepareStatement(stringUtils.GET_LOGIN_ADMIN_INFOS);
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

	public static userModel getUserByUsername(String userName) {
	    try (Connection con = getConn()) {
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ?");
	        ps.setString(1, userName);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            // Retrieve user data from ResultSet
	            String username = rs.getString("userName");
	            String firstName = rs.getString("firstName");
	            String lastName = rs.getString("lastName");
	            String gender = rs.getString("gender");
	            String email = rs.getString("email");
	            String phoneNumber = rs.getString("phoneNumber");
	            String password = rs.getString("password");
	            String city = rs.getString("city");
	            String province = rs.getString("province");
	            String country = rs.getString("country");
	            String postalCode = rs.getString("postalCode");

	            // Construct and return the userModel object
	            return new userModel(username, firstName, lastName, phoneNumber, null, email, password, city, province,
	                    country, postalCode, gender);
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace(); // Handle or log the exception properly
	    }
	    return null; // Return null if no user with the given username is found
	}



	public static boolean updateUser(userModel user) throws Throwable {
	    boolean success = false;
	    try (Connection con = getConn()) {
	        String query = "UPDATE users SET firstName = ?, lastName = ?, email = ?, phoneNumber = ?, "
	                + "city = ?, province = ?, country = ?, postalCode = ? WHERE userName = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, user.getFirstName());
	        ps.setString(2, user.getLastName());
	        ps.setString(3, user.getEmail());
	        ps.setString(4, user.getPhoneNumber());
	        ps.setString(5, user.getCity());
	        ps.setString(6, user.getProvince());
	        ps.setString(7, user.getCountry());
	        ps.setString(8, user.getPostalCode());
	        ps.setString(9, user.getUserName()); // Set username parameter last

	        int rowsUpdated = ps.executeUpdate();
	        success = rowsUpdated > 0;
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    return success;
	}
//delect user
	public static int deleteUser(String userName) {
        try (Connection con = getConn();
             PreparedStatement ps = con.prepareStatement(stringUtils.DELETE_USER)) {
            ps.setString(1, userName);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return -1;
        }
    }




}

