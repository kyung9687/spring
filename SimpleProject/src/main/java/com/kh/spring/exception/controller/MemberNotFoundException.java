package com.kh.spring.exception.controller;

public class MemberNotFoundException extends RuntimeException {

	public MemberNotFoundException(String message) {
		super(message);
	}
}
