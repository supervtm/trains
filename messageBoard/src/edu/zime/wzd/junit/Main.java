package edu.zime.wzd.junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.zime.wzd.domain.CustomReply;
import edu.zime.wzd.domain.Page;
import edu.zime.wzd.domain.User;
import edu.zime.wzd.mapper.MessageMapper;
import edu.zime.wzd.mapper.ReplyMapper;
import edu.zime.wzd.mapper.UserMapper;
import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext-*.xml" })
public class Main {


	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	

	@Test
	public void test() throws Exception {
		
		/*User user = new User("123", "123");
		try {
			userMapper.insert(user );
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		Page page = new Page();
		page.setStartPage(0);
//		List<CustomMessage> lists = messageMapper.queryByUser("1");
		List<CustomReply> list = replyMapper.queryByRootId("1");
		
		List<User> lists = userMapper.queryAll(page);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("lists", lists);
		
		System.out.println(jsonObject.toString());
		
		System.out.println("留言总数："+messageMapper.getTotlByUser(2));
		
		System.out.println(list.size());
	}
}
