package edu.zime.wzd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import edu.zime.wzd.domain.Page;
import edu.zime.wzd.domain.User;

/**
 * 查询、增加、修改用户
 * @author wchvt
 *
 */
public interface UserMapper {

	//@UpdateProvider(type = UserProvider.class, method = "updateSQL")
	//@Results(value = { @Result(property = "userName", column = "user_name", javaType = String.class, jdbcType = JdbcType.VARCHAR) }) 
	@Select("select * from t_user where username=#{username} and password=#{password}")
	public User query(User user) throws Exception;
	
	public List<User> queryAll(Page page) throws Exception;
	
	public void insert(User user) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(String userId) throws Exception;
}
