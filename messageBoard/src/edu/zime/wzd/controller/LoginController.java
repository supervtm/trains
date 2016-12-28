package edu.zime.wzd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.zime.wzd.domain.User;
import edu.zime.wzd.service.UserService;

/**
 * 登录、注销
 * 
 * @author wchvt
 *
 */
@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private UserService userService;

	/**
	 * 导向到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {

		// return "user/login";
		return "user/login";
	}

	/**
	 * 验证登录是否合法<br>
	 * 合法 跳转主页面<br>
	 * 用户信息持久化
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpSession session, Model model) {

		
		return "base";
	}

	/**
	 * 注销 清除用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		return null;
	}
}
