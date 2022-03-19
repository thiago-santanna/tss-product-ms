package com.tsswebapps.productms.exception.handles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tsswebapps.productms.exception.NegocioExceptionDto;
import com.tsswebapps.productms.exception.NotFoundException;

@ControllerAdvice("com.tsswebapps.productms.controller")
public class NotFoundHandler {

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public NegocioExceptionDto exceptionDto(NotFoundException exception) {
		return new NegocioExceptionDto(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}

}
