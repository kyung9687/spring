package com.kh.spring.exception.controller;

public class TooLargeValueException extends RuntimeException {
	
	public TooLargeValueException(String message) {
		super(message);
	}
}
