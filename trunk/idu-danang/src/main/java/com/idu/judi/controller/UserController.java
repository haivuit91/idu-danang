package com.idu.judi.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		Map<String, String> gender = new LinkedHashMap<String, String>();
		gender.put("1", "Male");
		gender.put("0", "Female");
		mav.addObject("gender", gender);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User user,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		// if (result.hasErrors())
		// return new ModelAndView("user-new");
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

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer userId) {
		ModelAndView mav = new ModelAndView("user-edit");
		User user = userService.findById(userId);
		mav.addObject("user", user);
		Map<String, String> gender = new LinkedHashMap<String, String>();
		gender.put("1", "Male");
		gender.put("0", "Female");
		mav.addObject("gender", gender);

		return mav;
	}

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user,
			BindingResult result, @PathVariable Integer userId,
			final RedirectAttributes redirectAttributes) throws UserNotFound {

		// if (result.hasErrors())
		// return new ModelAndView("user-edit");

		ModelAndView mav = new ModelAndView("redirect:/user/list");
		String message = "User " + user.getFullName()
				+ " was successfully updated.";

		userService.update(user);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer userId,
			final RedirectAttributes redirectAttributes) throws UserNotFound {

		ModelAndView mav = new ModelAndView("redirect:/user/list");

		User user = userService.delete(userId);
		String message = "User " + user.getFullName()
				+ " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}