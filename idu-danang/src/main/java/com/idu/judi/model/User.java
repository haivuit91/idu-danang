package com.idu.judi.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.idu.judi.converter.RoleConverter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User {

	@Id
	private int userId;

	private byte active;

	private String address;

	private String avatarPath;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthOfDay;

	private String email;

	private String fullName;

	private byte gender;

	private String idActive;

	private String idCard;

	private String phoneNumber;

	private String pwd;

	private String userName;

	// bi-directional many-to-one association to New
	@OneToMany(mappedBy = "user")
	private List<News> news;

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "roleId")
	@Convert(converter = RoleConverter.class)
	private Role role;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatarPath() {
		return this.avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public Date getBirthOfDay() {
		return this.birthOfDay;
	}

	public void setBirthOfDay(Date birthOfDay) {
		this.birthOfDay = birthOfDay;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getIdActive() {
		return this.idActive;
	}

	public void setIdActive(String idActive) {
		this.idActive = idActive;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<News> getNews() {
		return this.news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public News addNew(News news) {
		getNews().add(news);
		news.setUser(this);

		return news;
	}

	public News removeNew(News news) {
		getNews().remove(news);
		news.setUser(null);

		return news;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User))
			return false;
		User u=(User)obj;
		if(this.userId == u.getUserId())
			return true;
		return true;
	}
}