package edu.zime.wzd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.zime.wzd.domain.CustomReply;
import edu.zime.wzd.domain.Reply;

/**
 * 查询、增加回复
 * 
 * @author wchvt
 *
 */
public interface ReplyMapper {

	/*//查询用户回复
	@Select("SELECT t_reply.content, t_reply.time, t_message.content, "
			+ "t_message.time, t_user.nickname, t_user.head, t_user.userid FROM t_reply INNER JOIN "
			+ "t_message ON t_reply.rootId = t_message.messageId INNER JOIN "
			+ "t_user ON t_message.`user` = t_user.userid WHERE t_reply.`user` = #{userId} "
			+ "ORDER BY t_reply.time")
	public List<CustomMessageVo> queryAll(@Param("userId")String userId) throws Exception;*/

	//根据留言id查询回复
	@Select("SELECT t_reply.replyId, t_reply.content, t_reply.time, t_user.userid, "
			+ "t_user.nickname, t_user.head FROM t_reply INNER JOIN t_user "
			+ "ON t_reply.`user` = t_user.userid WHERE t_reply.`rootId` = #{messageId}")
	public List<CustomReply> queryByRootId(@Param("messageId") String messageId) throws Exception;

	@Insert("insert into t_reply(content, user, rootId) values(#{content}, #{user}, #{rootId})")
	public void insert(Reply reply) throws Exception;

}
