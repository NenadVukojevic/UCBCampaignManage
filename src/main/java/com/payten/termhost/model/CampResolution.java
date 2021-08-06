package com.payten.termhost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAMP_RESOLUTION")
public class CampResolution {
	@Id
	@Column(name = "RESOLUTION_ID")
	private Integer resolutionId;

	@Column(name = "RESOLUTION_VALUE")
	private String resolutionValue;

	public CampResolution() {
		super();
	}

	public CampResolution(Integer resolutionId, String resolutionValue) {
		super();
		this.resolutionId = resolutionId;
		this.resolutionValue = resolutionValue;
	}

	public Integer getResolutionId() {
		return resolutionId;
	}

	public void setResolutionId(Integer resolutionId) {
		this.resolutionId = resolutionId;
	}

	public String getResolutionValue() {
		return resolutionValue;
	}

	public void setResolutionValue(String resolutionValue) {
		this.resolutionValue = resolutionValue;
	}

	@Override
	public String toString() {
		return "CampResolution [resolutionId=" + resolutionId + ", resolutionValue=" + resolutionValue + "]";
	}

	
}
