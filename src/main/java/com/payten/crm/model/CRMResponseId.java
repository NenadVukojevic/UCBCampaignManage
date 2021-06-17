package com.payten.crm.model;

import java.io.Serializable;
import java.util.Objects;


public class CRMResponseId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String campaignId;
	String responseId;
	
	public CRMResponseId() {
		super();
	}
	
	public CRMResponseId(String campaignId, String responseId) {
		super();
		this.campaignId = campaignId;
		this.responseId = responseId;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		
		if(o == null || getClass() != o.getClass()) return false;
		
		CRMResponseId crmResponseId = (CRMResponseId) o;
		
		return campaignId.equals(crmResponseId.campaignId) &&
				responseId.equals(crmResponseId.responseId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(campaignId, responseId);
	}
	
}
