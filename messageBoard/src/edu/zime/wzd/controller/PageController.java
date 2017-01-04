package edu.zime.wzd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zime.wzd.domain.User;
import edu.zime.wzd.service.MessageService;
import edu.zime.wzd.service.UserService;

/**
 * 用于跳转页面
 * 
 * @author wchvt
 *
 */
@Controller
@RequestMapping("/page")
public class PageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {

		request.setAttribute("page", "admin/manager.jsp");
		return "base";
	}

	/**
	 * 导向登录界面
	 * 
	 * @return
	 */
	@RequestMapping("/tologin")
	public String tologin() {

		return "user/login";
	}

	/**
	 * 导向到主页面
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/main")
	public String toMain(HttpServletRequest request) throws Exception {

		//获取留言总数
		int total = messageService.getTotal();
		
		request.setAttribute("page", "user/main.jsp");
		request.setAttribute("total_message", total);
		// 显示主页面
		return "base";
	}

	/**
	 * 导向到主页面
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/me")
	public String toMe(HttpServletRequest request, HttpSession session) throws Exception {
		
		User value = userService.queryUser((User)session.getAttribute("user"));
		//更新user信息
		session.setAttribute("user", value);
		
		// 从session中取出用户userId
		User user = (User) session.getAttribute("user");
		Integer userId = user.getUserId();
		//获取用户留言总数
		int userTotal = messageService.getUserTotal(userId);
		
		request.setAttribute("page", "user/me.jsp");
		request.setAttribute("message_user", userTotal);
		// 显示主页面
		return "base";
	}
}
