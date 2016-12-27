package edu.zime.wzd.mapper;

import org.apache.ibatis.jdbc.SQL;

import edu.zime.wzd.domain.Page;
import edu.zime.wzd.domain.User;

public class UserProvider {
	/**
	 * udpate
	 * 
	 * @param UserDO
	 * 
	 * @return
	 */
	public String updateSQL(final User user, Page page) {
		return new SQL() {
			{
				UPDATE("t_user");
				SET("gmt_modified = now()");
				if (user.getUserName() != null) {
					SET("user_name = #{userName}");
				}
				WHERE("id = #{id}}");
			}
		}.toString();
	}
}
