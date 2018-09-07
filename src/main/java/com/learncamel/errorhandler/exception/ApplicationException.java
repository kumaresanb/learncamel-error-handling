package com.learncamel.errorhandler.exception;

public class ApplicationException extends Exception {
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ApplicationException(String s) {
		this.message=s;
	}
}
