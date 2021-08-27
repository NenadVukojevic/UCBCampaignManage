package com.payten.termhost.model.offus.dto;

import java.util.List;

public class BinRangeGroupDTO {
	private Integer binRangeGroupId;
	private String binRangeName;
	
	private List<Integer> members;

	public BinRangeGroupDTO() {
		super();
	}

	public BinRangeGroupDTO(Integer binRangeGroupId, String binRangeName, List<Integer> members) {
		super();
		this.binRangeGroupId = binRangeGroupId;
		this.binRangeName = binRangeName;
		this.members = members;
	}

	public Integer getBinRangeGroupId() {
		return binRangeGroupId;
	}

	public void setBinRangeGroupId(Integer binRangeGroupId) {
		this.binRangeGroupId = binRangeGroupId;
	}

	public String getBinRangeName() {
		return binRangeName;
	}

	public void setBinRangeName(String binRangeName) {
		this.binRangeName = binRangeName;
	}

	public List<Integer> getMembers() {
		return members;
	}

	public void setMembers(List<Integer> members) {
		this.members = members;
	}

	
}
