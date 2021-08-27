package com.payten.termhost.model.offus;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table (name="BIN_RANGE_GROUP_MEMBERS")
@IdClass(BinRangeGroupMemberId.class)
public class BinRangeGroupMember  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1959346100665095376L;

	@Id
	@Column(name="BIN_RANGE_GROUP_ID")
	private Integer binRangeGroupId;

	@Id
	@Column(name="BIN_RANGE_ID")
	private Integer binRangeId;

	public BinRangeGroupMember() {
		super();
	}

	public BinRangeGroupMember(Integer binRangeGroupId, Integer binRangeId) {
		super();
		this.binRangeGroupId = binRangeGroupId;
		this.binRangeId = binRangeId;
	}

	public Integer getBinRangeGroupId() {
		return binRangeGroupId;
	}

	public void setBinRangeGroupId(Integer binRangeGroupId) {
		this.binRangeGroupId = binRangeGroupId;
	}

	public Integer getBinRangeId() {
		return binRangeId;
	}

	public void setBinRangeId(Integer binRangeId) {
		this.binRangeId = binRangeId;
	}

	
}
