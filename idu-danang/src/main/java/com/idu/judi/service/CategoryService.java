package com.idu.judi.service;

import java.util.List;

import com.idu.judi.model.Category;

public interface CategoryService {

	List<Category> getListCategory();
	Category getCategoryById(int categoryId);
}
