package edu.zime.wzd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.zime.wzd.domain.CustomMessage;
import edu.zime.wzd.domain.Message;
import edu.zime.wzd.domain.Page;

/**
 * 查看、发布、修改、删除留言
 * 
 * @author wchvt
 *
 */
public interface MessageMapper {

	/*
	 * @Select("SELECT * FROM tsp_template WHERE id = #{id}")
	 * 
	 * @Results(value = { @Result(property = "userName", column = "user_name",
	 * javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	 */
	// 查询所有留言
	@Select("SELECT t_message.messageId, t_message.content, t_message.time, "
			+ "t_user.userid, t_user.nickname, t_user.head FROM t_message INNER JOIN "
			+ "t_user ON t_message.`user` = t_user.userid ORDER BY time desc limit #{startPage}, #{pageSize}")
	public List<CustomMessage> queryAll(Page page) throws Exception;
	
	// 查询用户的所有留言
	@Select("SELECT t_message.messageId, t_message.content, t_message.`user`, "
			+ "t_message.time FROM t_message WHERE `user`=#{userId} ORDER BY time DESC")
	public List<CustomMessage> queryByUser(@Param("userId") Integer userId) throws Exception;

	// 查询留言总数
	@Select("select COUNT(*) from t_message")
	public Integer getTotl() throws Exception;

	// 查询用户留言总数
	@Select("select COUNT(*) from t_message where user=#{userId}")
	public Integer getTotlByUser(@Param("userId") Integer userId) throws Exception;

	@Insert("insert into t_message values(null, #{content}, #{user}, null)")
	public void insertMessage(Message message) throws Exception;

	@Update("update t_message set content=#{content} where messageId=#{messageId}")
	public void updateMessage(Message message) throws Exception;

	@Delete("delete from t_message where messageId=#{messageId}")
	public void delMessage(@Param("messageId") String messageId) throws Exception;
}
