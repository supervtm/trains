package edu.zime.wzd.domain;

/**
 * 用户
 * @author wchvt
 *
 */
public class User {

	//用户Id
	private Integer userId;
	
	//用户名
	private String userName;
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
	}

	//昵称
	private String nickName;
	
	//密码
	private String password;
	
	//头像路径
	private String head;
	
	//是否被使用
	private Integer isUse;
	
	//状态 0为审核中,1为审核通过,2为审核不通过
	private Integer status;
	
	//权限 0为管理员，1为普通用户
	private Integer power;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", password=" + password
				+ ", head=" + head + ", isUse=" + isUse + ", status=" + status + ", power=" + power + "]";
	}
}
