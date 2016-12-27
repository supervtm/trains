package edu.zime.wzd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zime.wzd.domain.User;

/**
 * 管理员审核、删除用户
 * @author wchvt
 *
 */
@Controller
@RequestMapping("/admin")
public class ManagerController {

	/**
	 * 导向到审核页面
	 * @param userId
	 * @param user
	 */
	@RequestMapping(value="/verify", method=RequestMethod.GET)
	public String toVerify(){
		
		return "";
	}
	
	/**
	 * 查询所有用户信息
	 * @param currentPage 当前页面,用于分页
	 * @return json数据
	 */
	@RequestMapping(value="/query")
	@ResponseBody
	public String getUsers(int currentPage){
		
		return "";
	}
	
	/**
	 * 修改用户状态<br>
	 * 成功、失败，返回json信息
	 * @param userId
	 * @param user
	 */
	@RequestMapping(value="/verify", method=RequestMethod.POST)
	@ResponseBody
	public String verify(String userId, User user){
		
		return "";
	}
	
	/**
	 * 根据用户id删除用户
	 * @param userId
	 * @return 删除结果
	 */
	@RequestMapping(value="/del", method=RequestMethod.POST)
	@ResponseBody
	public String delete(String userId){
		
		return "";
	}
}
