package edu.zime.wzd.domain;

/**
 * message扩展类
 * @author wchvt
 *
 */
public class CustomMessage extends Message {

	private String userId;
	
	private String nickname;
	
	private String head;
	
	private Integer floor;

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

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}
}
