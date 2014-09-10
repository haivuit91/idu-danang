package com.idu.judi.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;









import com.idu.judi.model.Category;
import com.idu.judi.model.News;
import com.idu.judi.model.User;
import com.idu.judi.service.CategoryService;
import com.idu.judi.service.NewsService;
import com.idu.judi.service.UserService;
import com.idu.judi.util.ImageProcess;
import com.idu.judi.util.Support;

@Controller
@ManagedBean
@RequestScoped
public class NewsManagement {
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	

	private List<News> listNews;
	private List<Category> listCategory;
	private List<User> listUser;
	private News currentNews;
	private String resultMes;
	private Part image;
	private String oldTitle;
	
	
	public NewsManagement(){
		currentNews = new News(); 
		currentNews.setActive(false);
	}

	
	// action
	public String delete(int newsId){
		
		if(newsService.delete(newsId))
			resultMes = "Success";
		else
			resultMes = "Fail";
		return "news-manager.jsf";
	}
	public String active(News news){
		
		if(newsService.active(news.getNewsId(), !news.getActive()))
			resultMes = "Success";
		else
			resultMes = "Fail";
		return "news-manager.jsf";
	}
	public String preEdit(News news){
		setOldTitle(news.getTitle());
		setCurrentNews(news);
		return "news-edit";
	}
	public String create(){
		String path = "C:\\news\\";
		User u = new User();
		u.setUserId(1);
		currentNews.setActive(true);
		currentNews.setUser(u);
		currentNews.setPathImage(ImageProcess.saveImage(image, path));
		currentNews.setTimeCreated(Support.getCurrentDate());
		if(newsService.exitNews(currentNews)){
			resultMes = "Title readly exit";
			return null;
		}
			
		if(newsService.insert(currentNews))
			resultMes = "Success";
		else{
			resultMes = "faile";
			return null;
		}
		return "news-manager.jsf";
	}
	public String save(){	
		News temp = newsService.getNewsById(currentNews.getNewsId());	
		currentNews.setTimeCreated(temp.getTimeCreated());
		if(image != null){
			String path = "C:\\news\\";
			currentNews.setPathImage(ImageProcess.saveImage(image, path));
		}
		else
			currentNews.setPathImage(temp.getPathImage());
		if(newsService.exitNews(currentNews) && !currentNews.getTitle().equals(oldTitle)){
			resultMes = "Title readly exit";
			return null;
		}
		if(newsService.update(currentNews))
			resultMes = "Success";
		else{
			resultMes = "faile";
			return null;
		}
		return "news-manager.jsf";
	}
	

    
	
	
	
	
	
	// setter & getter
	public List<News> getListNews() {
		return newsService.getListNews();
	}

	public void setListNews(List<News> listNews) {
		this.listNews = listNews;
	}


	public News getCurrentNews() {
		return currentNews;
	}
	public void setCurrentNews(News currentNews) {
		this.currentNews = currentNews;
	}


	public String getResultMes() {
		return resultMes;
	}


	public void setResultMes(String resultMes) {
		this.resultMes = resultMes;
	}


	public List<Category> getListCategory() {
		return categoryService.getListCategory();
	}


	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}


	public Part getImage() {
		return image;
	}


	public void setImage(Part image) {
		this.image = image;
	}


	public List<User> getListUser() {
		return userService.findAll();
	}


	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}


	public String getOldTitle() {
		return oldTitle;
	}


	public void setOldTitle(String oldTitle) {
		this.oldTitle = oldTitle;
	}
	
	
}
