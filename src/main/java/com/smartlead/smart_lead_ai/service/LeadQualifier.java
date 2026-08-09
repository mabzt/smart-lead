package com.smartlead.smart_lead_ai.service;

import com.smartlead.smart_lead_ai.controller.dto.huggingface.response.ChatCompletionResponse;
import com.smartlead.smart_lead_ai.controller.dto.lead.request.LeadRequestDTO;

public interface LeadQualifier {

	ChatCompletionResponse qualify(LeadRequestDTO leadRequestDTO);

}
