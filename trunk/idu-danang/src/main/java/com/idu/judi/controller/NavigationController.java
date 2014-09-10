package com.idu.judi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = { "admin/admin" }, method = RequestMethod.GET)
	public ModelAndView userManager() {
		return new ModelAndView("admin/admin");
	}

}