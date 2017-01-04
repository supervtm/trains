package edu.zime.wzd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zime.wzd.domain.Page;
import edu.zime.wzd.domain.User;
import edu.zime.wzd.mapper.UserMapper;
import edu.zime.wzd.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryUser(User user) throws Exception {
			
		return userMapper.query(user);
	}

	@Override
	public List<User> queryAll(Page page) throws Exception {
		
		return userMapper.queryAll(page);
	}

	@Override
	public void insertUser(User user) throws Exception {
		
		userMapper.insert(user);
	}

	@Override
	public void updateUser(String userId, User user) throws Exception {
		
		user.setUserId(Integer.parseInt(userId));
		userMapper.update(user);
	}

	@Override
	public void checkUser(String userId, String status) throws Exception {
		
		userMapper.updateUser(userId, status);
	}

	@Override
	public void delUser(String userId) throws Exception {
		
		userMapper.delete(userId);
	}

	@Override
	public Integer getTotal() throws Exception {
		
		return userMapper.queryTotal();
	}

}
