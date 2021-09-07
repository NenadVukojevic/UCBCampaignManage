package com.payten.termhost.model.offus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "CAMP_BIN_RANGE")
@IdClass(CampaignBinRangeGroupId.class)
public class CampaignBinRangeGroup {
	@Id
	@Column(name = "CAMPAIGN_ID")
	private Integer campaignId;

	@Id
	@Column(name = "BIN_RANGE_GROUP_ID")
	private Integer binRangeGroupId;

	public CampaignBinRangeGroup() {
		super();
	}

	public CampaignBinRangeGroup(Integer campaignId, Integer binRangeGroupId) {
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

	
}
