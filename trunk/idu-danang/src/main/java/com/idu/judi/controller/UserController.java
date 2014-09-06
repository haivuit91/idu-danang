package com.idu.judi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idu.judi.exception.UserNotFound;
import com.idu.judi.model.User;
import com.idu.judi.service.UserService;
import com.idu.judi.validation.UserValidator;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("user-new", "user", new User());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User user,
			BindingResult result, final RedirectAttributes redirectAttributes) {
//		if (result.hasErrors())
//			return new ModelAndView("user-new");
		ModelAndView mav = new ModelAndView();
		String message = "User " + user.getFullName()
				+ " was successfully created.";
		userService.create(user);
		mav.setViewName("redirect:/user/list");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("user-list");
		List<User> userList = userService.findAll();
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping(value = "/edit/{userID}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer userID) {
		ModelAndView mav = new ModelAndView("user-edit");
		User user = userService.findById(userID);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/edit/{userID}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user,
			BindingResult result, @PathVariable Integer userID,
			final RedirectAttributes redirectAttributes) throws UserNotFound {

		System.out.println(user.getBirthOfDay());
		System.out.println(user.getEmail());
//		if (result.hasErrors())
//			return new ModelAndView("user-edit");

		ModelAndView mav = new ModelAndView("redirect:/user/list");
		String message = "User was successfully updated.";

		userService.update(user);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{userID}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer userID,
			final RedirectAttributes redirectAttributes) throws UserNotFound {

		ModelAndView mav = new ModelAndView("redirect:/user/list");

		User user = userService.delete(userID);
		String message = "User " + user.getFullName()
				+ " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}