package edu.zime.wzd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	@Select("select * from t_user where isuse=1 and status=1 and username=#{userName} and password=#{password}")
	public User query(User user) throws Exception;
	
	@Select("select * from t_user where userId=#{userId}")
	public User queryById(@Param("userId") String userId) throws Exception;
	
	@Select("select * from t_user limit #{startPage}, #{pageSize}")
	public List<User> queryAll(Page page) throws Exception;
	
	@Insert("insert into t_user values(null, #{userName}, #{nickName}, #{password}, #{head}, #{isUse}, #{status} ,#{power})")
	public void insert(User user) throws Exception;
	
	@Update("update t_user set nickname=#{nickName}, password=#{password}, head=#{head} where userId=#{userId}")
	public void update(User user) throws Exception;
	
	@Update("update t_user set status=#{status} where userId=#{userId}")
	public void updateUser(@Param("userId")String userId, @Param("status")String status) throws Exception;
	
	@Delete("delete from t_user where userId=#{userId}")
	public void delete(@Param("userId") String userId) throws Exception;
}
