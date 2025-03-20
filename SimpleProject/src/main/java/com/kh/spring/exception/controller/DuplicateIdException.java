package com.kh.spring.exception.controller;

public class DuplicateIdException extends RuntimeException {
	public DuplicateIdException(String message) {
		super(message);
	}
}
