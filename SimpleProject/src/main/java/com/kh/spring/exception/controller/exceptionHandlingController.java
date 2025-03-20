package com.kh.spring.exception.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class exceptionHandlingController {

	
	private ModelAndView createErrorResponse(String errorMsg,Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", e.getMessage())
		  .setViewName("include/error_page");
		log.info("발생예외:{}", errorMsg,e);
		
		return mv;
	}
	
	@ExceptionHandler(DuplicateIdException.class)
	protected ModelAndView duplicateIdException(DuplicateIdException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	
	
	@ExceptionHandler(PasswordMissMatchException.class)
	protected ModelAndView passwordMissMatchException(PasswordMissMatchException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	protected ModelAndView memberNotFoundException(MemberNotFoundException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	@ExceptionHandler(InvalidParameterException.class)
	protected ModelAndView invalidParameterException(InvalidParameterException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	@ExceptionHandler(TooLargeValueException.class)
	protected ModelAndView tooLargeValueException(TooLargeValueException e) {
		return createErrorResponse(e.getMessage(), e);
	}
}
