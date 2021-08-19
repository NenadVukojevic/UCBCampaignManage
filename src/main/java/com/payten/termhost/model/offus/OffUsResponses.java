package com.payten.termhost.model.offus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAMP_OFF_RESPONSES")
public class OffUsResponses {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GEN")
	@SequenceGenerator(name = "ID_GEN", sequenceName = "CAMP_OFF_RESPONSES_ID_SEQ", allocationSize = 1)
	@Column(name="RESPONSE_ID")
	private Integer responseId;

	@Column(name="RESPONSE_CODE")
	private String responseCode;

	@Column(name="RESPONSE_LABEL")
	private String responseLabel;

	@Column(name="CONFIRMATION")
	private boolean confirmation;

	public OffUsResponses(Integer responseId, String responseCode, String responseLabel, boolean confirmation) {
		super();
		this.responseId = responseId;
		this.responseCode = responseCode;
		this.responseLabel = responseLabel;
		this.confirmation = confirmation;
	}

	public OffUsResponses() {
		super();
	}

	public Integer getResponseId() {
		return responseId;
	}

	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseLabel() {
		return responseLabel;
	}

	public void setResponseLabel(String responseLabel) {
		this.responseLabel = responseLabel;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "OffUsResponses [responseId=" + responseId + ", responseCode=" + responseCode + ", responseLabel="
				+ responseLabel + ", confirmation=" + confirmation + "]";
	}



}
