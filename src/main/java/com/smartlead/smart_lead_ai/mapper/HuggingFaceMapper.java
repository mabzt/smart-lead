package com.smartlead.smart_lead_ai.mapper;

import com.smartlead.smart_lead_ai.config.huggingface.HuggingFaceConfigProperties;
import com.smartlead.smart_lead_ai.controller.dto.huggingface.request.ChatCompletionRequest;
import com.smartlead.smart_lead_ai.controller.dto.lead.request.LeadRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class HuggingFaceMapper {

	private static final String SYSTEM_PROMPT = """
			You are a lead qualification assistant. Analyze the incoming \
			message and determine if it is a qualified sales lead or just \
			a general inquiry. Your answer must be prefixed with Yes/No \
			- then explanation""";

	private final HuggingFaceConfigProperties configProperties;

	public ChatCompletionRequest mapRequest(LeadRequestDTO leadRequestDTO) {
		Objects.requireNonNull(leadRequestDTO.message(), "Message must not be null");

		return new ChatCompletionRequest(this.configProperties.model(),
				List.of(ChatCompletionRequest.ChatMessage.system(SYSTEM_PROMPT),
						ChatCompletionRequest.ChatMessage.user(leadRequestDTO.message())),
				this.configProperties.maxTokens(), this.configProperties.temperature(), this.configProperties.stream());

	}

}
