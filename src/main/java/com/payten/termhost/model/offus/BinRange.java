package com.payten.termhost.model.offus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="BIN_RANGES")
public class BinRange {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BIN_RANGE_ID_GEN")
	@SequenceGenerator(name = "BIN_RANGE_ID_GEN", sequenceName = "BIN_RANGES_ID_SEQ", allocationSize = 1)
	@Column(name="BIN_RANGE_ID")
	private Integer binRangeId;

	@Column(name="BIN_RANGE_START")
	private Integer binRangeStart;

	@Column(name="BIN_RANGE_END")
	private Integer binRangeEnd;

	@Column(name="BIN_RANGE_NAME")
	private String binRangeName;

	@Column(name="CARD_TYPE_ID")
	private Integer cardTypeId;

	public BinRange() {
		super();
	}

	public BinRange(Integer binRangeId, Integer binRangeStart, Integer binRangeEnd, String binRangeName,
			Integer cardTypeId) {
		super();
		this.binRangeId = binRangeId;
		this.binRangeStart = binRangeStart;
		this.binRangeEnd = binRangeEnd;
		this.binRangeName = binRangeName;
		this.cardTypeId = cardTypeId;
	}

	public Integer getBinRangeId() {
		return binRangeId;
	}

	public void setBinRangeId(Integer binRangeId) {
		this.binRangeId = binRangeId;
	}

	public Integer getBinRangeStart() {
		return binRangeStart;
	}

	public void setBinRangeStart(Integer binRangeStart) {
		this.binRangeStart = binRangeStart;
	}

	public Integer getBinRangeEnd() {
		return binRangeEnd;
	}

	public void setBinRangeEnd(Integer binRangeEnd) {
		this.binRangeEnd = binRangeEnd;
	}

	public String getBinRangeName() {
		return binRangeName;
	}

	public void setBinRangeName(String binRangeName) {
		this.binRangeName = binRangeName;
	}

	public Integer getCardTypeId() {
		return cardTypeId;
	}

	public void setCardTypeId(Integer cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	
}
