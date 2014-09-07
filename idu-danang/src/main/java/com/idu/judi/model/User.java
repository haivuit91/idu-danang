package com.idu.judi.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userID")
	private int userID;

	@Column(name = "userName")
	private String userName;

	@Column(name = "pwd")
	private String pwd;

	@Column(name = "fullName")
	private String fullName;

	@Column(name = "gender")
	private boolean gender;

	@Column(name = "birthOfDay")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthOfDay;

	@Column(name = "email")
	private String email;

	@Column(name = "active")
	private boolean active;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthOfDay() {
		return birthOfDay;
	}

	public void setBirthOfDay(Date birthOfDay) {
		this.birthOfDay = birthOfDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}