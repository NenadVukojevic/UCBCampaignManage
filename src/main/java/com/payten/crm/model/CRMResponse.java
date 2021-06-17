package com.payten.crm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@IdClass(CRMResponseId.class)
@Table(name="Kampanja_Odgovori_ATM")
public class CRMResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Kampanja_ID")
	String campaignId;
	
	@Id
	@Column(name="Odgovor_ID")
	String responseId;
	
	@Column(name="Odgovor_Naziv")
	String responseName;

	public CRMResponse() {
		super();
	}

	public CRMResponse(String campaignId, String responseId, String responseName) {
		super();
		this.campaignId = campaignId;
		this.responseId = responseId;
		this.responseName = responseName;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getResponseName() {
		return responseName;
	}

	public void setResponseName(String responseName) {
		this.responseName = responseName;
	}
	
	
}
