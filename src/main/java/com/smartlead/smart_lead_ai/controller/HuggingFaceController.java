package com.smartlead.smart_lead_ai.controller;

import com.smartlead.smart_lead_ai.controller.dto.huggingface.response.ChatCompletionResponse;
import com.smartlead.smart_lead_ai.controller.dto.lead.request.LeadRequestDTO;
import com.smartlead.smart_lead_ai.service.LeadQualifier;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HuggingFaceController {

	private final LeadQualifier leadQualifier;

	@PostMapping
	public ResponseEntity<ChatCompletionResponse> processLead(@RequestBody LeadRequestDTO leadRequestDTO) {
		return new ResponseEntity<>(this.leadQualifier.qualify(leadRequestDTO), HttpStatus.ACCEPTED);
	}

}
