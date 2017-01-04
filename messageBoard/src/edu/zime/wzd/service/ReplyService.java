package edu.zime.wzd.service;

import java.util.List;

import edu.zime.wzd.domain.CustomReply;
import edu.zime.wzd.domain.Reply;

/**
 * 用于查看、发布回复
 * @author wchvt
 *
 */
public interface ReplyService {
	
	/**
	 * 根据留言号查询回复
	 * @return
	 * @throws Exception
	 */
	public  List<CustomReply> queryByMessage(String messageId) throws Exception;
	
	/**
	 * 发布回复
	 * @param rootID为messageId
	 * @throws Exception
	 */
	public void saveReply(Integer userId, String rootId, Reply reply) throws Exception;
}
