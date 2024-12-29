package com.pjsoft.fms.exception;

public class RetryableException extends Exception {
	private static final long serialVersionUID = -2598102970878944978L;

	public RetryableException(String message) {
		super(message);
	}
}
