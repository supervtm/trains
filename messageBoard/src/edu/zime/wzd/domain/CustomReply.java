package edu.zime.wzd.domain;

/**
 * reply扩展类
 * @author wchvt
 *
 */
public class CustomReply extends Reply {

	private String userId;
	
	private String nickname;
	
	private String head;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
}
