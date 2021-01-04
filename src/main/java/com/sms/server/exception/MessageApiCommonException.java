package com.sms.server.exception;

public class MessageApiCommonException extends Exception {

	private static final long serialVersionUID = 3997442631544153990L;

	private String message;

	public MessageApiCommonException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CommonException [message=" + message + "]";
	}
}
