package com.shoppingcart.exception;

public class UserNotFound extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message;
	
	public UserNotFound(String message)
	{
		super(message);
		this.message=message;
	}

}
