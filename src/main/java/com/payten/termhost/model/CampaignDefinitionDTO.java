package com.payten.termhost.model;

public class CampaignDefinitionDTO {
	private String f1;
	private String f2;
	private String f3;
	private String f4;
	private String f5;
	private String f6;
	private String f7;
	private String f8;
	private int imageId;
	private int resolutionId;
	private int campaignId;
	private String campaignText;
	private int definitionId;

	public CampaignDefinitionDTO() {
		super();
	}

	public CampaignDefinitionDTO(String f1, String f2, String f3, String f4, String f5, String f6, String f7, String f8,
			int imageId, int resolutionId, int campaignId, String campaignText, int definitionId) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		this.f4 = f4;
		this.f5 = f5;
		this.f6 = f6;
		this.f7 = f7;
		this.f8 = f8;
		this.imageId = imageId;
		this.resolutionId = resolutionId;
		this.campaignId = campaignId;
		this.campaignText = campaignText;
		this.definitionId = definitionId;
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

	public int getResolutionId() {
		return resolutionId;
	}

	public void setResolutionId(int resolutionId) {
		this.resolutionId = resolutionId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignText() {
		return campaignText;
	}

	public void setCampaignText(String campaignText) {
		this.campaignText = campaignText;
	}

	public int getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(int definitionId) {
		this.definitionId = definitionId;
	}

	@Override
	public String toString() {
		return "CampaignDefinitionDTO [f1=" + f1 + ", f2=" + f2 + ", f3=" + f3 + ", f4=" + f4 + ", f5=" + f5 + ", f6="
				+ f6 + ", f7=" + f7 + ", f8=" + f8 + ", imageId=" + imageId + ", resolutionId=" + resolutionId
				+ ", campaignId=" + campaignId + ", campaignText=" + campaignText + ", definitionId=" + definitionId
				+ "]";
	}

}
