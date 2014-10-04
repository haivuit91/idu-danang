package com.idu.judi.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.idu.judi.model.Role;
import com.idu.judi.model.User;
import com.idu.judi.service.RoleService;
import com.idu.judi.service.UserService;

@Controller
@ManagedBean
@RequestScoped
public class UserManagement {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	private String msg;
	private User user;
	private List<Role> role;

	public UserManagement() {
		user = new User();
	}

	public List<User> listUser() {
		return userService.findAll();
	}

	public String navigation() {
		if (this.user == null) {
			msg = "1";
		} else {
			msg = "0";
		}
		return "add-edit-user";
	}

	public String createUser(ActionEvent even) {
		return "";
	}

	public String updateUser(ActionEvent even) {
		return "";
	}

	public String deleteUser(int userId) {
		if (userService.delete(userId)) {
			msg = "Deleted use succesfully!";
		} else {
			msg = "Deleted use failed!";
		}
		return "users-manager";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
