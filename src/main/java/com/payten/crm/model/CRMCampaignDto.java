package com.payten.crm.model;

import java.sql.Date;


public class CRMCampaignDto {
	
	String campaignId;

	String campaignName;

	String campaignDesc;

	Date startDate;

	Date endDate;
	
	boolean active;

	public CRMCampaignDto() {
		super();
	}

	public CRMCampaignDto(String campaignId, String campaignName, String campaignDesc, Date startDate, Date endDate,
			boolean active) {
		super();
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.campaignDesc = campaignDesc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = active;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignDesc() {
		return campaignDesc;
	}

	public void setCampaignDesc(String campaignDesc) {
		this.campaignDesc = campaignDesc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
