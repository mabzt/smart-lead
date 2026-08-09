package com.smartlead.smart_lead_ai.service;

import com.smartlead.smart_lead_ai.controller.dto.huggingface.request.ChatCompletionRequest;
import com.smartlead.smart_lead_ai.controller.dto.huggingface.response.ChatCompletionResponse;
import com.smartlead.smart_lead_ai.controller.dto.lead.request.LeadRequestDTO;
import com.smartlead.smart_lead_ai.mapper.HuggingFaceMapper;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HuggingFaceLeadQualifierImpl implements LeadQualifier {

	private final HuggingFaceMapper huggingFaceMapper;

	private final HuggingFaceApi huggingFaceApi;

	@Override
	@Retry(name = "huggingface")
	@RateLimiter(name = "huggingface")
	public ChatCompletionResponse qualify(LeadRequestDTO leadRequestDTO) {
		ChatCompletionRequest request = this.huggingFaceMapper.mapRequest(leadRequestDTO);
		var response = this.huggingFaceApi.completion(request);
		return null;
	}

}
