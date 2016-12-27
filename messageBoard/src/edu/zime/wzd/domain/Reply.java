package edu.zime.wzd.domain;

/**
 * 回复
 * 
 * @author wchvt
 *
 */
public class Reply {

	// 回复Id
	private Integer replyId;

	// 内容
	private String content;

	// 发布时间
	private String time;

	// 用户
	private Integer user;
	
	// 根帖
	private Integer rootId;
	
	// 父帖
	private Integer fatherId;
	
	// 深度
	private Integer depth;

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
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

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getRootId() {
		return rootId;
	}

	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", content=" + content + ", time=" + time + ", user=" + user + ", rootId="
				+ rootId + ", fatherId=" + fatherId + ", depth=" + depth + "]";
	}
}
