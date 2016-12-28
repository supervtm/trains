package edu.zime.wzd.service;

import java.util.List;

import edu.zime.wzd.domain.CustomMessage;
import edu.zime.wzd.domain.Message;
import edu.zime.wzd.domain.Page;

/**
 * 用于查看、发布、修改、删除留言
 * @author wchvt
 *
 */
public interface MessageService {
	
	/**
	 * 查询所有留言
	 * @param page 分页参数
	 * @return
	 * @throws Exception
	 */
	public  List<CustomMessage> queryMessages(Page page) throws Exception;
	
	/**
	 * 查询用户的所有留言
	 * @param user
	 * @return
	 */
	public List<CustomMessage> queryMessagesByUser(String userId) throws Exception;
	
	/**
	 * 发布留言
	 * @param customMessageVo
	 * @throws Exception
	 */
	public void saveMessage(String userId, Message message) throws Exception;
	
	/**
	 * 修改留言
	 * @param customMessageVo
	 * @throws Exception
	 */
	public void updateMessage(String messageId, Message message) throws Exception;
	
	/**
	 * 删除留言
	 * @param customMessageVo
	 * @throws Exception
	 */
	public void delMessage(String messageId) throws Exception;
}
