package com.payten.termhost.model.offus.dto;

public class BinRangeDTO {
	private Integer binRangeId;
	private String binRangeLabel;

	public BinRangeDTO() {
		super();
	}

	public BinRangeDTO(Integer binRangeId, String binRangeLabel) {
		super();
		this.binRangeId = binRangeId;
		this.binRangeLabel = binRangeLabel;
	}

	public Integer getBinRangeId() {
		return binRangeId;
	}

	public void setBinRangeId(Integer binRangeId) {
		this.binRangeId = binRangeId;
	}

	public String getBinRangeLabel() {
		return binRangeLabel;
	}

	public void setBinRangeLabel(String binRangeLabel) {
		this.binRangeLabel = binRangeLabel;
	}

}
