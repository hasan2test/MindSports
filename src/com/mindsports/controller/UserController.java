package com.mindsports.controller;

import com.jfinal.core.Controller;
import com.mindsports.dao.User;
import com.mindsports.service.IUserService;
import com.mindsports.service.impl.UserServiceImpl;

public class UserController extends Controller {
	/**
	 * login Ò³Ãæ
	 */
	public void login() {
		render("/login.jsp");
	}

	public void loginTo() {
		IUserService userService = new UserServiceImpl();
		User user = getModel(User.class);
		User userDB = userService.isLogin(user);
		if (userDB != null) {
			getSession().setAttribute("user", userDB);
			redirect("/");
		} else {
			renderJsp("/login.jsp");
		}
	}

}
