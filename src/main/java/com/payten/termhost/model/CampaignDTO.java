package com.payten.termhost.model;

import java.util.Date;
import java.util.List;

public class CampaignDTO {

	private Integer campaignId;
	private String campaignName;
	private String campaignDescription;
	private Date campaignStart;
	private Date campaignEnd;
	private String campaignText;
	private String externalId;
	private boolean contactCollecting;

	private List<CampaignDefinitionDTO> definitions;

	public CampaignDTO(Integer campaignId, String campaignName, String campaignDescription, Date campaignStart,
			Date campaignEnd, String campaignText, String externalId, boolean contactCollecting,
			List<CampaignDefinitionDTO> definitions) {
		super();
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.campaignDescription = campaignDescription;
		this.campaignStart = campaignStart;
		this.campaignEnd = campaignEnd;
		this.campaignText = campaignText;
		this.externalId = externalId;
		this.contactCollecting = contactCollecting;
		this.definitions = definitions;
	}

	public CampaignDTO() {
		super();
	}

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignDescription() {
		return campaignDescription;
	}

	public void setCampaignDescription(String campaignDescription) {
		this.campaignDescription = campaignDescription;
	}

	public Date getCampaignStart() {
		return campaignStart;
	}

	public void setCampaignStart(Date campaignStart) {
		this.campaignStart = campaignStart;
	}

	public Date getCampaignEnd() {
		return campaignEnd;
	}

	public void setCampaignEnd(Date campaignEnd) {
		this.campaignEnd = campaignEnd;
	}

	public String getCampaignText() {
		return campaignText;
	}

	public void setCampaignText(String campaignText) {
		this.campaignText = campaignText;
	}

	public List<CampaignDefinitionDTO> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<CampaignDefinitionDTO> definitions) {
		this.definitions = definitions;
	}

	public boolean isContactCollecting() {
		return contactCollecting;
	}

	public void setContactCollecting(boolean contactCollecting) {
		this.contactCollecting = contactCollecting;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@Override
	public String toString() {
		return "CampaignDTO [campaignId=" + campaignId + ", campaignName=" + campaignName + ", campaignDescription="
				+ campaignDescription + ", campaignStart=" + campaignStart + ", campaignEnd=" + campaignEnd
				+ ", campaignText=" + campaignText + ", externalId=" + externalId + ", contactCollecting="
				+ contactCollecting + ", definitions=" + definitions + "]";
	}

}
