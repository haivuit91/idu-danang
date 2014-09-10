package com.idu.judi.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idu.judi.exception.UserNotFound;
import com.idu.judi.model.Role;
import com.idu.judi.model.User;
import com.idu.judi.service.RoleService;
import com.idu.judi.service.UserService;

@Controller
@RequestMapping(value = "/admin")
@ManagedBean
@RequestScoped
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	FacesMessage mess;
	private User user;
	private List<Role> role;

	public UserController() {
		user = new User();
	}

	public List<User> listUser() {
		return userService.findAll();
	}

	/************* Mapping *************/
	@RequestMapping(value = "/user-manager", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("user-manager");
		return mav;
	}

	/************* Handling *************/
	public String deleteUser(int userId) throws UserNotFound {
		if (userService.delete(userId)) {
			mess = new FacesMessage("User " + user.getFullName()
					+ " was successfully deleted.");
		} else {
			mess = new FacesMessage("User " + user.getFullName()
					+ " was fail deleted.");
		}
		FacesContext.getCurrentInstance().addMessage("result", mess);
		return "user-manager";
	}

	public String createUser(ActionEvent event) {
		// String msg = "";
		String username = getUser().getUserName();
		String fullname = getUser().getFullName();
		String newpass = getUser().getPwd();
		String address = getUser().getAddress();
		String email = getUser().getEmail();

		System.out.println("user name: " + username + "user name: " + fullname
				+ "user name: " + newpass + "user name: " + address
				+ "user name: " + email);

		return "user-manager";
	}

	/************* Getters & Setters *************/
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRole() {
		role = roleService.findAllRole();
		return role;
	}

}