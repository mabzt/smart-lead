package com.smartlead.smart_lead_ai.controller.dto.huggingface.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChatCompletionRequest(String model, List<ChatMessage> messages,

		@JsonProperty("max_tokens") int maxTokens,

		BigDecimal temperature, boolean stream

) {

	public record ChatMessage(String role, String content) {

		public ChatMessage {
			Objects.requireNonNull(role, "Role cannot be null");
			Objects.requireNonNull(content, "Content cannot be null");
		}

		public static ChatMessage system(String content) {
			return new ChatMessage("system", content);
		}

		public static ChatMessage user(String content) {
			return new ChatMessage("user", content);
		}

	}

}
