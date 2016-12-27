package edu.zime.wzd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import edu.zime.wzd.domain.CustomMessageVo;

/**
 * 查看、发布、修改、删除留言
 * @author wchvt
 *
 */
public interface MessageMapper {

	/*@Select("SELECT * FROM tsp_template WHERE id = #{id}")
	@Results(value = { @Result(property = "userName", column = "user_name", javaType = String.class, jdbcType = JdbcType.VARCHAR) }) 
	public  List<CustomMessageVo> queryAll(@Param("startPage") int startPage) throws Exception;
	
	public List<CustomMessageVo> queryByUser(String userId, int startPage) throws Exception;
	
	public void insertMessage(CustomMessageVo customMessageVo) throws Exception;
	
	public void updateMessage(CustomMessageVo customMessageVo) throws Exception;
	
	public void delMessage(String messageId) throws Exception;*/
}
