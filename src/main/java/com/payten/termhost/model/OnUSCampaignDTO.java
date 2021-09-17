package com.payten.termhost.model;

import java.sql.Date;

public class OnUSCampaignDTO {
	private Integer campaignId;
	private String campaignName;
	private String campaignDescription;
	private Date campaignStart;
	private Date campaignEnd;
	private String campaignText;
	private Integer campaignStatus;
	private String f1;
	private String f2;
	private String f3;
	private String f4;
	private String f5;
	private String f6;
	private String f7;
	private String f8;
	private int imageId;

	public OnUSCampaignDTO() {
		super();
		campaignName = "";
		campaignDescription = "";
		campaignText = "";
		f1 = "";
		f2 = "";
		f3 = "";
		f4 = "";
		f5 = "";
		f6 = "";
		f7 = "";
		f8 = "";

	}

	public OnUSCampaignDTO(Integer campaignId, String campaignName, String campaignDescription, Date campaignStart,
			Date campaignEnd, String campaignText, Integer campaignStatus, String f1, String f2, String f3, String f4,
			String f5, String f6, String f7, String f8, int imageId) {
		super();
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.campaignDescription = campaignDescription;
		this.campaignStart = campaignStart;
		this.campaignEnd = campaignEnd;
		this.campaignText = campaignText;
		this.campaignStatus = campaignStatus;
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
		this.f5 = f5;
		this.f6 = f6;
		this.f7 = f7;
		this.f8 = f8;
		this.imageId = imageId;
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

	public String getF1() {
		return f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getF2() {
		return f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	public String getF3() {
		return f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	}

	public String getF4() {
		return f4;
	}

	public void setF4(String f4) {
		this.f4 = f4;
	}

	public String getF5() {
		return f5;
	}

	public void setF5(String f5) {
		this.f5 = f5;
	}

	public String getF6() {
		return f6;
	}

	public void setF6(String f6) {
		this.f6 = f6;
	}

	public String getF7() {
		return f7;
	}

	public void setF7(String f7) {
		this.f7 = f7;
	}

	public String getF8() {
		return f8;
	}

	public void setF8(String f8) {
		this.f8 = f8;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public Integer getCampaignStatus() {
		return campaignStatus;
	}

	public void setCampaignStatus(Integer campaignStatus) {
		this.campaignStatus = campaignStatus;
	}

}
