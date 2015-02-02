package com.mindsports.dao;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2632716601781228227L;
	public static final User me = new User();

}
