package com.idu.judi.model;

import javax.persistence.*;

/**
 * The persistent class for the news database table.
 * 
 */
@Entity
@Table(name = "news")
@NamedQuery(name = "New.findAll", query = "SELECT n FROM New n")
public class New {

	@Id
	private int newsId;

	private byte active;

	@Lob
	private String content;

	private String pathImage;

	private String timeCreated;

	private String title;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public New() {
	}

	public int getNewsId() {
		return this.newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
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

	public String getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(String timeCreated) {
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