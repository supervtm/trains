package edu.zime.wzd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zime.wzd.domain.CustomReply;
import edu.zime.wzd.domain.Reply;
import edu.zime.wzd.mapper.ReplyMapper;
import edu.zime.wzd.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public List<CustomReply> queryByMessage(String messageId) throws Exception {
	
		return replyMapper.queryByRootId(messageId);
	}

	@Override
	public void saveReply(Integer userId, String rootId, Reply reply) throws Exception {
		
		reply.setUser(userId);
		reply.setRootId(Integer.parseInt(rootId));
		replyMapper.insert(reply);

	}

}
