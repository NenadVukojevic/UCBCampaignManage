package com.payten.termhost.model.offus.dto;

import java.sql.Date;
import java.util.List;

public class OffUsCampaignDTO {

	private Integer campaignId;
	private String campaignName;
	private String campaignDescription;
	private Date campaignStart;
	private Date campaignEnd;
	private Integer campaignStatus;
	private String campaignText;
	private boolean contactCollecting;
	private String collectingText;
	private List<OffUsDefinitionsDTO> definitions;

	public OffUsCampaignDTO() {
		super();
	}

	public OffUsCampaignDTO(Integer campaignId, String campaignName, String campaignDescription, Date campaignStart,
			Date campaignEnd, Integer campaignStatus, String campaignText, boolean contactCollecting,
			String collectingText, List<OffUsDefinitionsDTO> definitions) {
		super();
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.campaignDescription = campaignDescription;
		this.campaignStart = campaignStart;
		this.campaignEnd = campaignEnd;
		this.campaignStatus = campaignStatus;
		this.campaignText = campaignText;
		this.contactCollecting = contactCollecting;
		this.collectingText = collectingText;
		this.definitions = definitions;
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

	public Integer getCampaignStatus() {
		return campaignStatus;
	}

	public void setCampaignStatus(Integer campaignStatus) {
		this.campaignStatus = campaignStatus;
	}

	public String getCampaignText() {
		return campaignText;
	}

	public void setCampaignText(String campaignText) {
		this.campaignText = campaignText;
	}

	public boolean isContactCollecting() {
		return contactCollecting;
	}

	public void setContactCollecting(boolean contactCollecting) {
		this.contactCollecting = contactCollecting;
	}

	public String getCollectingText() {
		return collectingText;
	}

	public void setCollectingText(String collectingText) {
		this.collectingText = collectingText;
	}

	public List<OffUsDefinitionsDTO> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<OffUsDefinitionsDTO> definitions) {
		this.definitions = definitions;
	}

	@Override
	public String toString() {
		return "OffUsCampaignDTO [campaignId=" + campaignId + ", campaignName=" + campaignName
				+ ", campaignDescription=" + campaignDescription + ", campaignStart=" + campaignStart + ", campaignEnd="
				+ campaignEnd + ", campaignStatus=" + campaignStatus + ", campaignText=" + campaignText
				+ ", contactCollecting=" + contactCollecting + ", collectingText=" + collectingText + ", definitions="
				+ definitions + "]";
	}

}
