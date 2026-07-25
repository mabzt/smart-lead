package com.smartlead.smart_lead_ai.controller.dto.huggingface.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record ChatCompletionResponse(String id, Long created, String model, List<Choice> choices, Usage usage) {

	public String firstContent() {
		if (this.choices == null || this.choices.isEmpty() || this.choices.getFirst().message() == null) {
			throw new IllegalStateException("No completion choices returned for response id=" + this.id);
		}
		return this.choices.getFirst().message().content();
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record Choice(Integer index, ResponseMessage message, @JsonProperty("finish_reason") String finishReason) {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record ResponseMessage(String role, String content) {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record Usage(@JsonProperty("prompt_tokens") Integer promptTokens,
			@JsonProperty("completion_tokens") Integer completionTokens,
			@JsonProperty("total_tokens") Integer totalTokens) {
	}

}
