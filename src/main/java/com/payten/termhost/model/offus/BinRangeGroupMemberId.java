package com.payten.termhost.model.offus;

import java.io.Serializable;
import java.util.Objects;

public class BinRangeGroupMemberId  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6022145445131050360L;
	
	private Integer binRangeGroupId;
	private Integer binRangeId;
	public BinRangeGroupMemberId() {
		super();
	}
	public BinRangeGroupMemberId(Integer binRangeGroupId, Integer binRangeId) {
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
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		
		if(o == null || getClass() != o.getClass()) return false;
		
		BinRangeGroupMemberId binRangeGroupMemberId = (BinRangeGroupMemberId) o;
		
		return binRangeGroupId.equals(binRangeGroupMemberId.binRangeGroupId) &&
				binRangeId.equals(binRangeGroupMemberId.binRangeId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(binRangeGroupId, binRangeId);
	}
}
