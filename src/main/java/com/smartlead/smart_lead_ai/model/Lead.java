package com.smartlead.smart_lead_ai.model;

import com.smartlead.smart_lead_ai.model.enums.LeadType;
import com.smartlead.smart_lead_ai.model.enums.UrgencyLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lead extends AuditorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqx_id")
	@SequenceGenerator(name = "id_sequence", sequenceName = "sqx_id")
	private Long id;

	private String title;

	@Enumerated(EnumType.STRING)
	private LeadType leadType;

	@Enumerated(EnumType.STRING)
	private UrgencyLevel urgencyLevel;

	private String summary;

}
