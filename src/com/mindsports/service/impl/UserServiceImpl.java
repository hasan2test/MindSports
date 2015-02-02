package com.mindsports.service.impl;
import com.mindsports.dao.User;
import com.mindsports.service.IUserService;


public class UserServiceImpl implements IUserService{

	@Override
	public User isLogin(User user) {
		String sql = "select * from user where username=? and password=?";

		User userDB = null;
		if (user != null) {
			userDB = User.me.findFirst(sql, user.get("username"),
					user.get("password"));
		}
		return userDB;
	}

}
