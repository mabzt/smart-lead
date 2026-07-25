package com.smartlead.smart_lead_ai.controller.advice;

import com.smartlead.smart_lead_ai.exceptions.LeadNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(LeadNotFoundException.class)
	ProblemDetail handleLeadNotFoundException(LeadNotFoundException exception) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
		problemDetail.setTitle("Lead not found");
		problemDetail.setProperty("timestamp", LocalDateTime.now());
		return problemDetail;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders httpHeaders, HttpStatusCode httpStatusCode, WebRequest webRequest) {
		ProblemDetail problemDetail = exception.getBody();
		problemDetail.setProperty("errors",
				exception.getBindingResult()
					.getFieldErrors()
					.stream()
					.map(fieldError -> Map.of("field", fieldError.getField(), "message",
							Objects.requireNonNullElse(fieldError.getDefaultMessage(), "invalid")))
					.toList());
		return ResponseEntity.of(problemDetail).build();
	}

	@ExceptionHandler(Exception.class)
	ProblemDetail handleInternalErrorException(Exception exception, HttpServletRequest httpServletRequest) {
		String errorId = UUID.randomUUID().toString();
		log.error("Unhandled exception [{}] {} {}", errorId, httpServletRequest.getMethod(), httpServletRequest);
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				"An unexpected error occurred");
		problemDetail.setProperty("errorId", errorId);
		return problemDetail;
	}

}
