package com.payten.termhost.model.offus;

import java.io.Serializable;
import java.util.Objects;

public class CampaignTerminalGroupId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4048303603042469531L;
	private Integer campaignId;
	private Integer terminalGroupId;

	public CampaignTerminalGroupId() {
		super();
	}

	public CampaignTerminalGroupId(Integer campaignId, Integer terminalGroupId) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		CampaignTerminalGroupId groupMemberId = (CampaignTerminalGroupId) o;

		return terminalGroupId.equals(groupMemberId.terminalGroupId) && campaignId.equals(groupMemberId.campaignId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(terminalGroupId, campaignId);
	}
}
