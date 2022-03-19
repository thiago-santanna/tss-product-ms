package com.tsswebapps.productms.exception;

public class NegocioExceptionDto {
	private int statusCode;
	private String message;

	public NegocioExceptionDto(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatus_code() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

}
