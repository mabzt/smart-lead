package com.smartlead.smart_lead_ai.exceptions;

public class LeadNotFoundException extends RuntimeException {

	public LeadNotFoundException(String message) {
		super(message);
	}

	public LeadNotFoundException(String messsage, Throwable throwable) {
		super(messsage, throwable);
	}

}
