package com.payten.termhost.model.offus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.payten.termhost.model.AtmBackground;
import com.payten.termhost.model.CampResolution;

@Entity
@Table(name = "CAMP_OFF_DEFINITIONS")
public class OffUsDefinitions {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GEN")
	@SequenceGenerator(name = "ID_GEN", sequenceName = "CAMP_OFF_DEFINITION_ID_SEQ", allocationSize = 1)
	@Column(name="CAMP_DEFINITION_ID")
	private Integer campDefinitionId;

	/*
	 * @Column(name="CAMPAIGN_ID") private Integer campaignId;
	 */

	@OneToOne
	@JoinColumn(name="RESOLUTION_ID")
	private CampResolution resolution;

	@OneToOne
	@JoinColumn(name = "BTN_1")
	private OffUsResponses btn1;

	@OneToOne
	@JoinColumn(name = "BTN_2")
	private OffUsResponses btn2;
	
	@OneToOne
	@JoinColumn(name = "BTN_3")
	private OffUsResponses btn3;

	@OneToOne
	@JoinColumn(name = "BTN_4")
	private OffUsResponses btn4;

	@OneToOne
	@JoinColumn(name = "BTN_5")
	private OffUsResponses btn5;

	@OneToOne
	@JoinColumn(name = "BTN_6")
	private OffUsResponses btn6;

	@OneToOne
	@JoinColumn(name = "BTN_7")
	private OffUsResponses btn7;

	@OneToOne
	@JoinColumn(name = "BTN_8")
	private OffUsResponses btn8;

	@OneToOne
	@JoinColumn(name = "IMAGE_ID")
	private AtmBackground atmBackground;

	public OffUsDefinitions() {
		super();
	}

	public OffUsDefinitions(Integer campDefinitionId, Integer campaignId, CampResolution resolution, OffUsResponses btn1,
			OffUsResponses btn2, OffUsResponses btn3, OffUsResponses btn4, OffUsResponses btn5, OffUsResponses btn6,
			OffUsResponses btn7, OffUsResponses btn8, AtmBackground atmBackground) {
		super();
		this.campDefinitionId = campDefinitionId;
//		this.campaignId = campaignId;
		this.resolution = resolution;
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

	public Integer getCampDefinitionId() {
		return campDefinitionId;
	}

	public void setCampDefinitionId(Integer campDefinitionId) {
		this.campDefinitionId = campDefinitionId;
	}

	/*
	 * public Integer getCampaignId() { return campaignId; }
	 * 
	 * public void setCampaignId(Integer campaignId) { this.campaignId = campaignId;
	 * }
	 */
	public CampResolution getResolution() {
		return resolution;
	}

	public void setResolution(CampResolution resolution) {
		this.resolution = resolution;
	}

	public OffUsResponses getBtn1() {
		return btn1;
	}

	public void setBtn1(OffUsResponses btn1) {
		this.btn1 = btn1;
	}

	public OffUsResponses getBtn2() {
		return btn2;
	}

	public void setBtn2(OffUsResponses btn2) {
		this.btn2 = btn2;
	}

	public OffUsResponses getBtn3() {
		return btn3;
	}

	public void setBtn3(OffUsResponses btn3) {
		this.btn3 = btn3;
	}

	public OffUsResponses getBtn4() {
		return btn4;
	}

	public void setBtn4(OffUsResponses btn4) {
		this.btn4 = btn4;
	}

	public OffUsResponses getBtn5() {
		return btn5;
	}

	public void setBtn5(OffUsResponses btn5) {
		this.btn5 = btn5;
	}

	public OffUsResponses getBtn6() {
		return btn6;
	}

	public void setBtn6(OffUsResponses btn6) {
		this.btn6 = btn6;
	}

	public OffUsResponses getBtn7() {
		return btn7;
	}

	public void setBtn7(OffUsResponses btn7) {
		this.btn7 = btn7;
	}

	public OffUsResponses getBtn8() {
		return btn8;
	}

	public void setBtn8(OffUsResponses btn8) {
		this.btn8 = btn8;
	}

	public AtmBackground getAtmBackground() {
		return atmBackground;
	}

	public void setAtmBackground(AtmBackground atmBackground) {
		this.atmBackground = atmBackground;
	}

	@Override
	public String toString() {
		return "OffUsDefinitions [campDefinitionId=" + campDefinitionId +  ", resolution="
				+ resolution + ", btn1=" + btn1 + ", btn2=" + btn2 + ", btn3=" + btn3 + ", btn4=" + btn4 + ", btn5="
				+ btn5 + ", btn6=" + btn6 + ", btn7=" + btn7 + ", btn8=" + btn8 + ", atmBackground=" + atmBackground
				+ "]";
	}
	
	

}
