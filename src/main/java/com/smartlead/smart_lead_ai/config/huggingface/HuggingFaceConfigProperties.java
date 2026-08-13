package com.smartlead.smart_lead_ai.config.huggingface;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
@ConfigurationProperties(prefix = "huggingface")
public record HuggingFaceConfigProperties(
//@formatter:off
		@NotNull Boolean enabled,
		@NotBlank String baseUrl,
		@NotBlank String token,
		@NotNull int maxTokens,
		@NotNull BigDecimal temperature,
		@NotNull boolean stream,
		@NotNull String model) {
	//@formatter:on
}
