package com.asso.frontend.model;


//import lombok.Data;
//
//@Data
public class User {
		
	 private Integer id;
	 private String firstName;
	 private String lastName;
	 private Integer age;
	 private String email;
	 private String password;
	public synchronized Integer getId() {
		return id;
	}
	public synchronized void setId(Integer id) {
		this.id = id;
	}
	public synchronized String getFirstName() {
		return firstName;
	}
	public synchronized void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public synchronized String getLastName() {
		return lastName;
	}
	public synchronized void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public synchronized Integer getAge() {
		return age;
	}
	public synchronized void setAge(Integer age) {
		this.age = age;
	}
	public synchronized String getEmail() {
		return email;
	}
	public synchronized void setEmail(String email) {
		this.email = email;
	}
	public synchronized String getPassword() {
		return password;
	}
	public synchronized void setPassword(String password) {
		this.password = password;
	}
}
