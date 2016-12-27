package edu.zime.wzd.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.zime.wzd.domain.User;
import edu.zime.wzd.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext-*.xml" })
public class Main {


	@Autowired
	private UserMapper userMapper;
	

	@Test
	public void insert() {
		
		User user = new User("123", "123");
		try {
			userMapper.insert(user );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
