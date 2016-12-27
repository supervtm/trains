package edu.zime.wzd.service;

import java.util.List;

import edu.zime.wzd.domain.CustomMessageVo;
import edu.zime.wzd.domain.Page;

/**
 * 用于查看、发布、修改、删除留言
 * @author wchvt
 *
 */
public interface MessageService {
	
	/**
	 * 查询所有留言和回复
	 * @param page 分页参数
	 * @return
	 * @throws Exception
	 */
	public  List<CustomMessageVo> queryMessage(Page page) throws Exception;
	
	/**
	 * 查询用户的留言和回复
	 * @param user
	 * @return
	 */
	public List<CustomMessageVo> queryMessageByUser(String userId, Page page) throws Exception;
	
	/**
	 * 发布留言或回复
	 * @param customMessageVo
	 * @throws Exception
	 */
	public void saveMessage(CustomMessageVo customMessageVo) throws Exception;
	
	/**
	 * 修改留言
	 * @param customMessageVo
	 * @throws Exception
	 */
	public void updateMessage(String messageId, CustomMessageVo customMessageVo) throws Exception;
	
	/**
	 * 删除留言
	 * @param customMessageVo
	 * @throws Exception
	 */
	public void delMessage(String messageId) throws Exception;
}
