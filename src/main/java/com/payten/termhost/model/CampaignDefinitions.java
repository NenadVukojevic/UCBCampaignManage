package com.payten.termhost.model;

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
@Table(name = "CAMP_DEFINITIONS")
public class CampaignDefinitions {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DB_SEQUENCE_ID")
	@SequenceGenerator(name = "DB_SEQUENCE_ID", sequenceName = "CAMP_DEFINITION_ID_SEQ", allocationSize = 1)
	@Column(name="CAMP_DEFINITION_ID")
	private Integer definitionId;
	
	@Column(name = "CAMPAIGN_ID")
	private Integer campaignId;

	@OneToOne
	@JoinColumn(name="RESOLUTION_ID")
	private CampResolution resolution;
	
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

	@Override
	public String toString() {
		return "CampaignDefinitions [definitionId=" + definitionId + ", campaignId=" + campaignId + ", resolution="
				+ resolution + ", btn1=" + btn1 + ", btn2=" + btn2 + ", btn3=" + btn3 + ", btn4=" + btn4 + ", btn5="
				+ btn5 + ", btn6=" + btn6 + ", btn7=" + btn7 + ", btn8=" + btn8 + ", atmBackground=" + atmBackground
				+ "]";
	}

	public CampaignDefinitions() {
		super();
	}

	public Integer getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(Integer definitionId) {
		this.definitionId = definitionId;
	}

	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public CampResolution getResolution() {
		return resolution;
	}

	public void setResolution(CampResolution resolution) {
		this.resolution = resolution;
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
