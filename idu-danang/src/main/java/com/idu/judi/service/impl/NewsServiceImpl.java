package com.idu.judi.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.idu.judi.model.News;
import com.idu.judi.repository.NewsRepository;
import com.idu.judi.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{

	@Resource
	private NewsRepository newsRepository;
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public boolean active(int newsId, boolean isActive) {
		News news = getNewsById(newsId);
		news.setActive(isActive);
		newsRepository.save(news);
		
		return true;
	}

	@Override
	@Transactional
	public boolean insert(News news) {
		news.setNewsId(0);
		// TODO Auto-generated method stub
		newsRepository.save(news);
		
		return true;
	}

	@Override
	@Transactional
	public boolean update(News news) {
		newsRepository.save(news);
		return true;
	}

	@Override
	@Transactional
	public boolean delete(int newsId) {
		try {
			newsRepository.delete(newsId);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	@Transactional
	public boolean exitNews(News news) {
		
		return entityManager.createQuery("select n from News as n where n.title='"+news.getTitle()+"' ").getResultList().size() > 0;
	}

	@Override
	@Transactional
	public News getNewsByTitle(String title) {
		
		return null;
	}

	@Override
	@Transactional
	public News getNewsById(int newsId) {
		// TODO Auto-generated method stub
		return newsRepository.findOne(newsId);
	}

	@Override
	@Transactional
	public List<News> getListNews() {
		// TODO Auto-generated method stub
		return newsRepository.findAll();
	}

}
