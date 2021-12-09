package com.nagarro.springmvc.service;

import com.nagarro.springmvc.model.Login;
import com.nagarro.springmvc.model.User;


/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Register.
	 *
	 * @param user the user
	 * @return the int
	 */
	int register(User user);

	/**
	 * Validate user.
	 *
	 * @param login the login
	 * @return the user
	 */
	User validateUser(Login login);
}
