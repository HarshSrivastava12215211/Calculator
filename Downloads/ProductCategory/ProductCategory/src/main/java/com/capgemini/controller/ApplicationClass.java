package com.capgemini.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // it is very important to run the code 
public class ApplicationClass {
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "Wrong endpoint Please Try on the correct one.." ; 
	}
}
