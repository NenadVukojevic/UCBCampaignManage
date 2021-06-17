package com.payten.termhost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAMP_STATUS")
public class CampaignStatus {

	@Id
	@Column(name="STATUS_ID")
	private Integer statusId;
	
	@Column(name="STATUS_NAME")
	private String statusName;

	public CampaignStatus() {
		super();
	}

	public CampaignStatus(Integer statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
