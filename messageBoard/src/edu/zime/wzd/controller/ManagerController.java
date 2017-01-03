package edu.zime.wzd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zime.wzd.domain.Page;
import edu.zime.wzd.domain.User;
import edu.zime.wzd.service.UserService;
import net.sf.json.JSONObject;

/**
 * 管理员审核、删除用户
 * @author wchvt
 *
 */
@Controller
@RequestMapping("/admin")
public class ManagerController {
	
	@Autowired
	private UserService userService;

	/**
	 * 查询所有用户信息
	 * @param currentPage 当前页面,用于分页
	 * @return json数据
	 * @throws Exception 
	 */
	@RequestMapping(value="/query", produces="text/html;charset=utf-8")
	@ResponseBody
	public String getUsers(int currentPage) throws Exception{
		
		Page page = new Page();
		
		page.setCurrentPage(currentPage);
		//设置显示的是从第几记录开始
		page.setStartPage((currentPage - 1)*page.getPageSize());
		//获取所有用户记录
		page.setTotal(userService.getTotal());
		
		page.setPageCount((page.getTotal()-1)/page.getPageSize()+1);
		
		//查询所有用户信息
		List<User> list=userService.queryAll(page);
		
		JSONObject resultJSON = new JSONObject();
		resultJSON.put("lists", list);
		resultJSON.put("page", page);
		return resultJSON.toString();
	}
	
	/**
	 * 修改用户审核状态<br>
	 * 成功、失败，返回json信息
	 * @param userId
	 * @param user
	 * @throws Exception 
	 */
	@RequestMapping(value="/verify", method=RequestMethod.POST)
	@ResponseBody
	public String verify(String userId, String status) throws Exception{
		
		userService.checkUser(userId, status);
		
		JSONObject resultJSON = new JSONObject();
		resultJSON.put("status", "success");
		return resultJSON.toString();
	}
	
	/**
	 * 根据用户id删除用户
	 * @param userId
	 * @return 删除结果
	 * @throws Exception
	 */
	
	@RequestMapping(value="/del", method=RequestMethod.POST)
	@ResponseBody
	public String delete(String userId) throws Exception{
		
		userService.delUser(userId);
		
		JSONObject resultJSON = new JSONObject();
		resultJSON.put("status", "success");
		return resultJSON.toString();
	}
}
