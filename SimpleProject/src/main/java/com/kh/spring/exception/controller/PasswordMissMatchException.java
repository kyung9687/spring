package com.kh.spring.exception.controller;

public class PasswordMissMatchException extends RuntimeException {
	public PasswordMissMatchException(String message) {
		super(message);
	}
}
