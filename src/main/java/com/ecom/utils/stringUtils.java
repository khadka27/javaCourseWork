package com.ecom.utils;

public class stringUtils {

	public static final String Insert_User = "INSERT INTO users (userName,firstName,lastName,phoneNumber,birthday,email,password,city,province,country,postalCode,gender) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String GET_LOGIN_USER_INFOS = "SELECT userName ,password from users where userName = ? And password = ?";

	public static final String GET_USER = "SELECT * from users";

	public static final String GET_HASHED_PASSWORD = "SELECT password FROM users WHERE userName = ?";

}
