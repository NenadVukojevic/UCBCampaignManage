package com.payten.termhost.model.offus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="BIN_RANGE_GROUPS")
public class BinRangeGroup {
	@Id
	@Column(name="BIN_RANGE_GROUP_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BIN_RANGE_ID_GEN")
	@SequenceGenerator(name = "BIN_RANGE_ID_GEN", sequenceName = "BIN_RANGE_GROUP_ID_SEQ", allocationSize = 1)
	private Integer binRangeGroupId;

	@Column(name="BIN_RANGE_NAME")
	private String binRangeName;

	public BinRangeGroup() {
		super();
	}

	public BinRangeGroup(Integer binRangeGroupId, String binRangeName) {
		super();
		this.binRangeGroupId = binRangeGroupId;
		this.binRangeName = binRangeName;
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

	
}
