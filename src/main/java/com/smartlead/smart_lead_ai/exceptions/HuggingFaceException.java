package com.smartlead.smart_lead_ai.exceptions;

public class HuggingFaceException extends RuntimeException {

	public HuggingFaceException(String message) {
		super(message);
	}

	public HuggingFaceException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
