package com.idu.judi.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

@ManagedBean
@RequestScoped
@Controller
public class ContacBean {
	private String fullName;
	private String email;
	private String phone;
	private String content;
	private String title;

	public void submit(ActionEvent event) {
		String msg;
		if (com.idu.judi.util.Support.sendMailContact(fullName, email, phone,
				title, content)) {
			msg = "Feedback send successfully!";
		} else {
			msg = "Feedback send successfully!";
		}
		this.addMessages(msg);
	}

	public void addMessages(String msg) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg,
				"Message!");
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getTitle() {
		return title;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
