package com.smartlead.smart_lead_ai.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record LeadRequestDto(

		@Schema(name = "firstName", description = "Lead requestor's  first name", example = "Thato",
				requiredMode = Schema.RequiredMode.REQUIRED) @NotEmpty(
						message = "First name is required") String firstName,

		@Schema(description = "Lead requestor's last name", example = "Mabeleng",
				requiredMode = Schema.RequiredMode.REQUIRED) @NotEmpty(
						message = "Last name is required.") String lastName,

		@Schema(description = "lead requestor's email address", example = "john.cena@email.com",
				requiredMode = Schema.RequiredMode.REQUIRED) @NotEmpty(message = "Email address is required.") @Email(
						message = "Invalid email address") String emailAddress,

		String phoneNumber,

		@Schema(description = "Lead message", requiredMode = Schema.RequiredMode.REQUIRED,
				example = "“Hi, I love your product! Keep up\n" + "the great work.”") @Size(min = 50,
						max = 255) @NotEmpty(message = "Message is required") String message

) {
}
