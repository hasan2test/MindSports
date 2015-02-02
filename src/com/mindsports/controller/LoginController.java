package com.mindsports.controller;

import com.jfinal.core.Controller;

public class LoginController extends Controller {
	/**
	 * 登陆页面
	 */
	public void login() {
		render("/login.jsp");
	}
}
