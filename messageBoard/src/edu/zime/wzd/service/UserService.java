package edu.zime.wzd.service;

import java.util.List;

import edu.zime.wzd.domain.Page;
import edu.zime.wzd.domain.User;

/**
 * 用于用户登录、注册以及修改信息
 * @author wchvt
 *
 */
public interface UserService {

	/**
	 *  查询用户是否存在<br>
	 * @param user domain对象 包含账号和密码
	 * @return 查询结果
	 * @throws Exception
	 */
	public User queryUser(User user) throws Exception;
	
	/**
	 * 查询所有用户信息 分页
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<User> queryAll(Page page) throws Exception;
	
	/**
	 * 添加用户
	 * @param user domain对象 包含账号和密码
	 * @throws Exception
	 */
	public void insertUser(User user) throws Exception;
	
	/**
	 * 修改用户信息
	 * @param user
	 * @throws Exception
	 */
	public void updateUser(String userId, User user) throws Exception;
	
	/**
	 * 修改用户审核状态
	 * @param userId
	 * @param user
	 * @throws Exception
	 */
	public void updateStatus(String userId) throws Exception;
	
	/**
	 * 删除用户
	 * @param user
	 * @throws Exception
	 */
	public void delUser(String userId) throws Exception;
	
}
