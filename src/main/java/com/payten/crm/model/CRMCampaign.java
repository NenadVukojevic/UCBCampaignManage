package com.payten.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="Kampanje_Aktivne_ATM")
public class CRMCampaign {
	@Id
	@Column(name="Kampanja_ID")
	String campaignId;
	
	@Column(name="Kampanja_Naziv")
	String campaignName;
	
	@Column(name="Kampanja_Opis")
	String campaignDesc;
	
	@Column(name="Start_Kampanje_Datum")
	Date startDate;
	
	@Column(name="Kraj_Kampanje_Datum")
	Date endDate;

	public CRMCampaign() {
		super();
	}

	public CRMCampaign(String campaignId, String campaignName, String campaignDesc, Date startDate, Date endDate) {
		super();
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.campaignDesc = campaignDesc;
		this.startDate = startDate;
		this.endDate = endDate;
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
	
	
}
