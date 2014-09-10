package com.idu.judi.model;

import java.sql.Date;

import javax.persistence.*;

/**
 * The persistent class for the news database table.
 * 
 */
@Entity
@Table(name = "news")
@NamedQuery(name = "New.findAll", query = "SELECT n FROM News n")
public class News {

	@Id
	private int newsId;

	private boolean active;

	@Lob
	private String content;

	private String pathImage;

	private Date timeCreated;

	private String title;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public News() {
	}

	public int getNewsId() {
		return this.newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPathImage() {
		return this.pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public Date getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}