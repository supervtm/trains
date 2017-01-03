package edu.zime.wzd.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.zime.wzd.domain.User;
import edu.zime.wzd.service.UserService;

/**
 * 用户注册、修改信息
 * 
 * @author wchvt
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 导向到注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String toLogin() {
	
		return "user/register";
	}

	/**
	 * 用户注册<br>
	 * 注册成功跳转主页面<br>
	 * 用户信息持久化
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String login(User user, HttpSession session) throws Exception {
		user.setNickName(user.getUserName());
		
		userService.insertUser(user);
		
		return "redirect:/page/main";
	}

	/**
	 * 修改用户信息 上传图片<br>
	 * 修改成功，返回成功信息(json)
	 * 
	 * @param session
	 * @return	json字符串
	 * @throws Exception 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(User user, String head, MultipartFile imageFile, HttpServletRequest request, HttpSession session) throws IllegalStateException, Exception {

		if (imageFile.getSize() != 0) {
			// 原始文件名称
			String pictureFile_name = imageFile.getOriginalFilename();
			// 新文件名称
			String newFileName = UUID.randomUUID().toString()
					+ pictureFile_name.substring(pictureFile_name.lastIndexOf("."));

			// 上传图片
			String savePath = request.getServletContext().getRealPath("/images");
			File uploadPic = new File(savePath + "/" + newFileName);

			if (!uploadPic.exists()) {
				uploadPic.mkdirs();
			}
			// 向磁盘写文件
			imageFile.transferTo(uploadPic);
			
			//设置头像名称
			user.setHead(newFileName);
		} else {
			//设置原来的头像名称
			user.setHead(head);
		}
		
		// 从session中取出用户userId
		User user2 = (User) session.getAttribute("user");
		Integer userId = user2.getUserId();
		
		userService.updateUser(userId.toString(), user);
		
		return "redirect:/page/me";
	}
}
