package com.smartlead.smart_lead_ai.model.enums;

import lombok.Getter;

@Getter
public enum LeadType {

	/**
	 * Request for a demo.
	 */
	DEMO_REQUEST,

	/**
	 * Price enquiry.
	 */
	PRICING_INQUIRY,

	/**
	 * Partnership enquiry.
	 */
	PARTNERSHIP,

	/**
	 * Support lead.
	 */
	SUPPORT,

	/**
	 * Unclassified lead request.
	 */
	OTHER

}
