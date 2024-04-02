/**
 * 
 */
package com.ecom.model;

import java.time.LocalDate;

public class userModel {

	private String userName;
    private String firstName;
	private String lastName;
	private String phoneNumber;
	private LocalDate birthday;
	private String email;
	private String password;
	private String city;
	private String province;
	private String country;
	private String postalCode;
	private String gender;
	
	
	public userModel(String userName, String firstName, String lastName, String phoneNumber, LocalDate birthday,
			String email, String password, String city, String province, String country, String postalCode,
			String gender) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
		this.gender = gender;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}




	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public static void setPassword(String hashedPassword) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
