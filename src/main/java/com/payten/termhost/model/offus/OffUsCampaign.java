package com.payten.termhost.model.offus;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.payten.termhost.model.CampaignStatus;

@Entity
@Table(name = "CAMP_OFF")
public class OffUsCampaign {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMPAIGN_ID_GEN")
	@SequenceGenerator(name = "CAMPAIGN_ID_GEN", sequenceName = "CAMP_OFF_ID_SEQ", allocationSize = 1)
	@Column(name = "CAMPAIGN_ID")
	private Integer campaignId;

	@Column(name = "CAMPAIGN_NAME")
	private String campaignName;

	@Column(name = "CAMPAIGN_DESCRIPTION")
	private String campaignDescription;

	@Column(name = "CAMPAIGN_START")
	private Date campaignStart;

	@Column(name = "CAMPAIGN_END")
	private Date campaignEnd;

	@OneToOne
	@JoinColumn(name = "CAMPAIGN_STATUS")
	private CampaignStatus campaignStatus;

	@Column(name = "CAMPAIGN_TEXT")
	private String campaignText;

	@Column(name = "CONTACT_COLLECTING")
	private boolean contactCollecting;

	@Column(name = "COLLECTING_TEXT")
	private String collectingText;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CAMPAIGN_ID", referencedColumnName = "CAMPAIGN_ID")
	private List<OffUsDefinitions> definitions = new ArrayList<OffUsDefinitions>();

	public OffUsCampaign() {
		super();
	}

	public OffUsCampaign(Integer campaignId, String campaignName, String campaignDescription, Date campaignStart,
			Date campaignEnd, CampaignStatus campaignStatus, String campaignText, boolean contactCollecting,
			String collectingText, List<OffUsDefinitions> definitions) {
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

	public CampaignStatus getCampaignStatus() {
		return campaignStatus;
	}

	public void setCampaignStatus(CampaignStatus campaignStatus) {
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

	public List<OffUsDefinitions> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<OffUsDefinitions> definitions) {
		this.definitions = definitions;
	}

	@Override
	public String toString() {
		return "OffUsCampaign [campaignId=" + campaignId + ", campaignName=" + campaignName + ", campaignDescription="
				+ campaignDescription + ", campaignStart=" + campaignStart + ", campaignEnd=" + campaignEnd
				+ ", campaignStatus=" + campaignStatus + ", campaignText=" + campaignText + ", contactCollecting="
				+ contactCollecting + ", collectingText=" + collectingText + ", definitions=" + definitions + "]";
	}

}
