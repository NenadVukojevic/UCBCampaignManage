package com.payten.termhost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAMP_RULES")
public class CampaignRule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CAMPAIGN_RULE_ID_GEN")
	@SequenceGenerator(name = "CAMPAIGN_RULE_ID_GEN", sequenceName = "CAMP_RULES_ID_SEQ", allocationSize = 1)
	@Column(name = "CAMP_RULE_ID")
	private Integer campaignRuleId;

	@Column(name = "CAMPAIGN_ID")
	private Integer campaignId;

	@Column(name = "TERMINAL_GROUP_ID")
	private Integer terminalGroupId;

	@Column(name = "BIN_RANGE_GROUP_ID")
	private Integer binRangeGroupId;

	@Column(name = "CUSTOMER_GROUP_ID")
	private Integer customerGroupId;

	@Column(name = "EXTERNAL_ID")
	private String externalId;

	public CampaignRule() {
		super();
	}

	public CampaignRule(Integer campaignRuleId, Integer campaignId, Integer terminalGroupId, Integer binRangeGroupId,
			Integer customerGroupId, String externalId) {
		super();
		this.campaignRuleId = campaignRuleId;
		this.campaignId = campaignId;
		this.terminalGroupId = terminalGroupId;
		this.binRangeGroupId = binRangeGroupId;
		this.customerGroupId = customerGroupId;
		if (externalId == null) {
			this.externalId = "";
		} else {
			this.externalId = externalId;
		}
	}

	public Integer getCampaignRuleId() {
		return campaignRuleId;
	}

	public void setCampaignRuleId(Integer campaignRuleId) {
		this.campaignRuleId = campaignRuleId;
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

	public Integer getBinRangeGroupId() {
		return binRangeGroupId;
	}

	public void setBinRangeGroupId(Integer binRangeGroupId) {
		this.binRangeGroupId = binRangeGroupId;
	}

	public Integer getCustomerGroupId() {
		return customerGroupId;
	}

	public void setCustomerGroupId(Integer customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		if (externalId == null) {
			this.externalId = "";
		} else {
			this.externalId = externalId;
		}
	}

}
