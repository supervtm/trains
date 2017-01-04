package edu.zime.wzd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zime.wzd.domain.CustomMessage;
import edu.zime.wzd.domain.Message;
import edu.zime.wzd.domain.Page;
import edu.zime.wzd.mapper.MessageMapper;
import edu.zime.wzd.service.MessageService;

public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;

	@Override
	public List<CustomMessage> queryMessages(Page page) throws Exception {
		
		return messageMapper.queryAll(page);
	}

	@Override
	public List<CustomMessage> queryMessagesByUser(Integer userId) throws Exception {
		
		return  messageMapper.queryByUser(userId);
	}

	@Override
	public void saveMessage(Integer userId, Message message) throws Exception {
		message.setUser(userId);
		messageMapper.insertMessage(message);
		
	}

	@Override
	public void updateMessage(String messageId, Message message) throws Exception {
		
		message.setMessageId(Integer.parseInt(messageId));
		messageMapper.updateMessage(message);
		
	}

	@Override
	public void delMessage(String messageId) throws Exception {
		
		messageMapper.delMessage(messageId);	
	}

	@Override
	public int getTotal() throws Exception {
		
		return messageMapper.getTotl();
	}

	@Override
	public int getUserTotal(Integer userId) throws Exception {
		
		return messageMapper.getTotlByUser(userId);
	}

}
