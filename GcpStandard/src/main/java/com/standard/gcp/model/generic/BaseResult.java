package com.standard.gcp.model.generic;

public class BaseResult {
	
	private String message;
	
	public BaseResult(String message) {
		super();
		this.message = message;
	}
	
	public BaseResult() 
	{
		super();
		this.message = "Successful operation";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
