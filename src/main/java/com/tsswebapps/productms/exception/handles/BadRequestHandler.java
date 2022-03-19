package com.tsswebapps.productms.exception.handles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tsswebapps.productms.exception.BadRequestException;
import com.tsswebapps.productms.exception.NegocioExceptionDto;

@ControllerAdvice("com.tsswebapps.productms.controller")
public class BadRequestHandler {

	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public NegocioExceptionDto exceptionDto(BadRequestException exception) {
		return new NegocioExceptionDto(HttpStatus.BAD_REQUEST.value(),
				exception.getMessage());
		
	}
}
