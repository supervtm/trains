package edu.zime.wzd.controller;

import java.text.SimpleDateFormat;

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

		// 显示login页面
		return "user/login";
	}
	

	/**
	 * 验证登录是否合法<br>
	 * 合法 跳转主页面<br>
	 * 用户信息持久化
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpSession session, Model model) throws Exception {
	
		User login=	userService.queryUser(user);
		
		//登陆成功跳转主页面，不成功跳回登录页面
		if(login!=null){
			login.setCreateTime(new SimpleDateFormat("yy-MM-dd HH:mm").format(new SimpleDateFormat("yy-MM-dd HH:mm").parse(login.getCreateTime())));
			session.setAttribute("user", login);
			return "redirect:/page/main";
		}else{
			model.addAttribute("erro", "用户名或密码错误");
			return "forward:/page/tologin";
		}
		/*user.setUserName("admin");
		user.setPassword("123");
		User login=	userService.queryUser(user);
		login.setCreateTime(new SimpleDateFormat("yy-MM-dd HH:mm").format(new SimpleDateFormat("yy-MM-dd HH:mm").parse(login.getCreateTime())));
		session.setAttribute("user", login);
		return "redirect:/page/main";*/
	}

	/**
	 * 注销 清除用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.removeAttribute("user");
		return "redirect:/user/login";
	}
}
