package com.idu.judi.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.idu.judi.model.Category;
import com.idu.judi.repository.CategoryRepository;
import com.idu.judi.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Resource
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional
	public List<Category> getListCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	@Transactional
	public Category getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return categoryRepository.findOne(categoryId);
	}

}
