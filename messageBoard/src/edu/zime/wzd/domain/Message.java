package edu.zime.wzd.domain;

/**
 * 留言
 * 
 * @author wchvt
 *
 */
public class Message {

	// 留言Id
	private Integer messageId;

	// 内容
	private String content;

	// 发布时间
	private String time;

	// 深度
	private Integer user;
	
	// 深度
	private Integer depth;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", content=" + content + ", time=" + time + ", user=" + user
				+ ", depth=" + depth + "]";
	}
}
