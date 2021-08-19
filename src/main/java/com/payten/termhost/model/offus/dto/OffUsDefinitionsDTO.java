package com.payten.termhost.model.offus.dto;

public class OffUsDefinitionsDTO {
	private int definitionId;
	private int campaignId;
	private int f1;
	private int f2;
	private int f3;
	private int f4;
	private int f5;
	private int f6;
	private int f7;
	private int f8;
	private int imageId;
	private int resolutionId;

	public OffUsDefinitionsDTO(int definitionId, int campaignId, int f1, int f2, int f3, int f4, int f5, int f6,
			int f7, int f8, int imageId, int resolutionId) {
		super();
		this.definitionId = definitionId;
		this.campaignId = campaignId;
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
	}

	public OffUsDefinitionsDTO() {
		super();
	}

	public int getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(int definitionId) {
		this.definitionId = definitionId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public int getF1() {
		return f1;
	}

	public void setF1(int f1) {
		this.f1 = f1;
	}

	public int getF2() {
		return f2;
	}

	public void setF2(int f2) {
		this.f2 = f2;
	}

	public int getF3() {
		return f3;
	}

	public void setF3(int f3) {
		this.f3 = f3;
	}

	public int getF4() {
		return f4;
	}

	public void setF4(int f4) {
		this.f4 = f4;
	}

	public int getF5() {
		return f5;
	}

	public void setF5(int f5) {
		this.f5 = f5;
	}

	public int getF6() {
		return f6;
	}

	public void setF6(int f6) {
		this.f6 = f6;
	}

	public int getF7() {
		return f7;
	}

	public void setF7(int f7) {
		this.f7 = f7;
	}

	public int getF8() {
		return f8;
	}

	public void setF8(int f8) {
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

	@Override
	public String toString() {
		return "OffUssDefinitionsDTO [definitionId=" + definitionId + ", campaignId=" + campaignId + ", f1=" + f1
				+ ", f2=" + f2 + ", f3=" + f3 + ", f4=" + f4 + ", f5=" + f5 + ", f6=" + f6 + ", f7=" + f7 + ", f8=" + f8
				+ ", imageId=" + imageId + ", resolutionId=" + resolutionId + "]";
	}

}
