package com.nagarro.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.springmvc.model.User;
import com.nagarro.springmvc.service.UserService;


/**
 * The Class RegistrationController.
 */
@Controller
public class RegistrationController {
	
	/** The user service. */
	@Autowired
	public UserService userService;

	/**
	 * Show register.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());

		return mav;
	}

	/**
	 * Adds the user.
	 *
	 * @param request the request
	 * @param response the response
	 * @param user the user
	 * @return the model and view
	 */
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {

		userService.register(user);

		return new ModelAndView("welcome", "firstname", user.getFirstname());
	}
}
