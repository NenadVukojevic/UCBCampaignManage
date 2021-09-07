package com.payten.termhost.model.offus;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "CAMP_TERMINAL_GROUP")
@IdClass(CampaignTerminalGroupId.class)
public class CampaignTerminalGroups implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9032451516766519048L;

	@Id
	@Column(name = "CAMPAIGN_ID")
	private Integer campaignId;

	@Id
	@Column(name = "TERMINAL_GROUP_ID")
	private Integer terminalGroupId;

	public CampaignTerminalGroups() {
		super();
	}

	public CampaignTerminalGroups(Integer campaignId, Integer terminalGroupId) {
		super();
		this.campaignId = campaignId;
		this.terminalGroupId = terminalGroupId;
	}

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public Integer getTerminalGroupId() {
		return terminalGroupId;
	}

	public void setTerminalGroupId(Integer terminalGroupId) {
		this.terminalGroupId = terminalGroupId;
	}

}
