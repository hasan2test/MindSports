package com.mindsports.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.mindsports.controller.IndexController;
import com.mindsports.controller.LoginInterceptor;
import com.mindsports.controller.UserController;
import com.mindsports.dao.User;

public class MindSportsConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		loadPropertyFile("a_little_config.txt");
		me.setDevMode(getPropertyToBoolean("devMode", false));
		me.setViewType(ViewType.JSP);
	}

	public void configRoute(Routes me) {

		me.add(new FrontRoutes()); // 端端路由
		me.add(new AdminRoutes()); // 后端路由
	}

	public class AdminRoutes extends Routes {
		public void config() {
			// add("/admin", AdminController.class);
			// add("/admin/user", UserController.class);
		}
	}

	public class FrontRoutes extends Routes {
		public void config() {
			add("/", IndexController.class);
			add("/i", UserController.class);
		}
	}

	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
				getProperty("user"), getProperty("password").trim());
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user", User.class);
	}

	public void configInterceptor(Interceptors me) {
		me.add(new LoginInterceptor());
	}

	public void configHandler(Handlers me) {
	}

	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
}
