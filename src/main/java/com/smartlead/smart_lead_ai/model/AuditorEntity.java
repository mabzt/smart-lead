package com.smartlead.smart_lead_ai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditorEntity {

	@JsonIgnore
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Instant createdAt;

	@CreatedBy
	@JsonIgnore
	@Column(nullable = false, updatable = false)
	private String createdBy = "SYSTEM";

}
