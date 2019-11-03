package com.qantas.airport.controller;

import java.net.ConnectException;

import javax.validation.ConstraintViolationException;
import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.qantas.airport.domain.ErrorMessage;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	ErrorMessage exceptionHandler(ValidationException e) {
		e.printStackTrace();
		return new ErrorMessage("400", e.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ HttpClientErrorException.class })
	ErrorMessage exceptionHandler(HttpClientErrorException e) {
		e.printStackTrace();
		return new ErrorMessage(String.valueOf(e.getStatusCode().value()), e.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ ConnectException.class })
	ErrorMessage exceptionHandler(ConnectException e) {
		e.printStackTrace();
		return new ErrorMessage("500", e.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ ConstraintViolationException.class })
	ErrorMessage exceptionHandler(ConstraintViolationException e) {
		e.printStackTrace();
		return new ErrorMessage("400", e.getMessage());
	}
}
