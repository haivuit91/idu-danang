package com.idu.judi.model;

import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category {

	@Id
	private int categoryId;

	private byte active;

	private String categoryName;

	// bi-directional many-to-one association to New
	@OneToMany(mappedBy = "category")
	private List<News> news;

	public Category() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<News> getNews() {
		return this.news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public News addNew(News news) {
		getNews().add(news);
		news.setCategory(this);

		return news;
	}

	public News removeNew(News news) {
		getNews().remove(news);
		news.setCategory(null);

		return news;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Category))
			return false;
		Category category =(Category)obj;
		if(this.categoryId == category.getCategoryId())
			return true;
		return false;
		
	}
}