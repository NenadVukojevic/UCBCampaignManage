package com.payten.termhost.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAMPAIGNS")
public class THCampaign {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMPAIGN_ID_GEN")
	@SequenceGenerator(name = "CAMPAIGN_ID_GEN", sequenceName = "CAMPAIGN_ID_SEQ", allocationSize = 1)
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

	@Column(name = "CAMPAIGN_IMG_URL")
	private String campaignImgUrl;

	@OneToOne
	@JoinColumn(name = "BTN_1")
	private ButtonLabel btn1;

	@OneToOne
	@JoinColumn(name = "BTN_2")
	private ButtonLabel btn2;

	@OneToOne
	@JoinColumn(name = "BTN_3")
	private ButtonLabel btn3;

	@OneToOne
	@JoinColumn(name = "BTN_4")
	private ButtonLabel btn4;

	@OneToOne
	@JoinColumn(name = "BTN_5")
	private ButtonLabel btn5;

	@OneToOne
	@JoinColumn(name = "BTN_6")
	private ButtonLabel btn6;

	@OneToOne
	@JoinColumn(name = "BTN_7")
	private ButtonLabel btn7;

	@OneToOne
	@JoinColumn(name = "BTN_8")
	private ButtonLabel btn8;

	@OneToOne
	@JoinColumn(name = "IMAGE_ID")
	private AtmBackground atmBackground;

	public THCampaign() {
			super();
			this.campaignText = "";
		}

	public THCampaign(Integer campaignId, String campaignName, String campaignDescription, Date campaignStart,
				Date campaignEnd, CampaignStatus campaignStatus, String campaignText, String campaignImgUrl,
				ButtonLabel btn1, ButtonLabel btn2, ButtonLabel btn3, ButtonLabel btn4, ButtonLabel btn5, ButtonLabel btn6,
				ButtonLabel btn7, ButtonLabel btn8, AtmBackground atmBackground) {
			super();
			this.campaignId = campaignId;
			this.campaignName = campaignName;
			this.campaignDescription = campaignDescription;
			this.campaignStart = campaignStart;
			this.campaignEnd = campaignEnd;
			this.campaignStatus = campaignStatus;
			this.campaignText = campaignText;
			this.campaignImgUrl = campaignImgUrl;
			this.btn1 = btn1;
			this.btn2 = btn2;
			this.btn3 = btn3;
			this.btn4 = btn4;
			this.btn5 = btn5;
			this.btn6 = btn6;
			this.btn7 = btn7;
			this.btn8 = btn8;
			this.atmBackground = atmBackground;
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

	public String getCampaignImgUrl() {
		return campaignImgUrl;
	}

	public void setCampaignImgUrl(String campaignImgUrl) {
		this.campaignImgUrl = campaignImgUrl;
	}

	public ButtonLabel getBtn1() {
		return btn1;
	}

	public void setBtn1(ButtonLabel btn1) {
		this.btn1 = btn1;
	}

	public ButtonLabel getBtn2() {
		return btn2;
	}

	public void setBtn2(ButtonLabel btn2) {
		this.btn2 = btn2;
	}

	public ButtonLabel getBtn3() {
		return btn3;
	}

	public void setBtn3(ButtonLabel btn3) {
		this.btn3 = btn3;
	}

	public ButtonLabel getBtn4() {
		return btn4;
	}

	public void setBtn4(ButtonLabel btn4) {
		this.btn4 = btn4;
	}

	public ButtonLabel getBtn5() {
		return btn5;
	}

	public void setBtn5(ButtonLabel btn5) {
		this.btn5 = btn5;
	}

	public ButtonLabel getBtn6() {
		return btn6;
	}

	public void setBtn6(ButtonLabel btn6) {
		this.btn6 = btn6;
	}

	public ButtonLabel getBtn7() {
		return btn7;
	}

	public void setBtn7(ButtonLabel btn7) {
		this.btn7 = btn7;
	}

	public ButtonLabel getBtn8() {
		return btn8;
	}

	public void setBtn8(ButtonLabel btn8) {
		this.btn8 = btn8;
	}

	public AtmBackground getAtmBackground() {
		return atmBackground;
	}

	public void setAtmBackground(AtmBackground atmBackground) {
		this.atmBackground = atmBackground;
	}
}
