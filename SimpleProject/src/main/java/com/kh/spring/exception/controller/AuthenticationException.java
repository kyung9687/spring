package com.kh.spring.exception.controller;

public class AuthenticationException extends RuntimeException {
	public AuthenticationException(String message) {
		super(message);
	}
}
