package com.smartlead.smart_lead_ai.service;

import com.smartlead.smart_lead_ai.controller.dto.huggingface.request.ChatCompletionRequest;
import com.smartlead.smart_lead_ai.controller.dto.huggingface.response.ChatCompletionResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/v1")
public interface HuggingFaceApi {

	@PostExchange("/chat/completions")
	ChatCompletionResponse completion(@RequestBody ChatCompletionRequest chatCompletionRequest);

}
