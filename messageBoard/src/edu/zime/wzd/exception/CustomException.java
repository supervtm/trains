package edu.zime.wzd.exception;

/**
 * 自定义异常 用于统一异常处理
 * 
 * @author wchvt
 *
 */
public class CustomException extends Exception {

	private static final long serialVersionUID = 5849649168146516L;

	private String message;

	public CustomException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
