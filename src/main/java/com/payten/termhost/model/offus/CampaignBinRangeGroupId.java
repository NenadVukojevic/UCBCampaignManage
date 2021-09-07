package com.payten.termhost.model.offus;

import java.io.Serializable;
import java.util.Objects;

public class CampaignBinRangeGroupId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1762486158556844671L;
	private Integer campaignId;
	private Integer binRangeGroupId;

	public CampaignBinRangeGroupId() {
		super();
	}

	public CampaignBinRangeGroupId(Integer campaignId, Integer binRangeGroupId) {
		super();
		this.campaignId = campaignId;
		this.binRangeGroupId = binRangeGroupId;
	}

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public Integer getBinRangeGroupId() {
		return binRangeGroupId;
	}

	public void setBinRangeGroupId(Integer binRangeGroupId) {
		this.binRangeGroupId = binRangeGroupId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		
		if(o == null || getClass() != o.getClass()) return false;
		
		CampaignBinRangeGroupId campaingBinRangeGroupMemberId = (CampaignBinRangeGroupId) o;
		
		return binRangeGroupId.equals(campaingBinRangeGroupMemberId.binRangeGroupId) &&
				campaignId.equals(campaingBinRangeGroupMemberId.campaignId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(binRangeGroupId, campaignId);
	}
}
