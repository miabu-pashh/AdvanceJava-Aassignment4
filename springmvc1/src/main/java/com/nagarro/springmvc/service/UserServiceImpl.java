package com.nagarro.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.springmvc.dao.UserDao;
import com.nagarro.springmvc.model.Login;
import com.nagarro.springmvc.model.User;


/**
 * The Class UserServiceImpl.
 */
public class UserServiceImpl implements UserService {

	/** The user dao. */
	@Autowired
	public UserDao userDao;

	/**
	 * Register.
	 *
	 * @param user the user
	 * @return the int
	 */
	public int register(User user) {
//	    return userDao.register(user);
		return 1;
	}

	/**
	 * Validate user.
	 *
	 * @param login the login
	 * @return the user
	 */
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

}
