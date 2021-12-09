package com.nagarro.springmvc.dao;

import com.nagarro.springmvc.model.Login;
import com.nagarro.springmvc.model.User;


/**
 * The Interface UserDao.
 */
public interface UserDao {

	/**
	 * Register.
	 *
	 * @param user the user
	 */
	void register(User user);

	/**
	 * Validate user.
	 *
	 * @param login the login
	 * @return the user
	 */
	User validateUser(Login login);
}