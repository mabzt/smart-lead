package com.smartlead.smart_lead_ai.config.huggingface;

import com.smartlead.smart_lead_ai.service.HuggingFaceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(HuggingFaceConfigProperties.class)
public class HuggingFaceClientConfig {

	private final HuggingFaceConfigProperties configProperties;

	@Bean
	public HuggingFaceApi huggingFaceService() {
		RestClient restClient = RestClient.builder()
			.baseUrl(this.configProperties.baseUrl())
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer" + this.configProperties.token())
			.build();

		return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
			.build()
			.createClient(HuggingFaceApi.class);
	}

}
