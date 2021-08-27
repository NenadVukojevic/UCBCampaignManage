package com.payten.termhost.model.offus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "TERMINALS")
public class Terminals {
	@Id
	@Column(name = "TERMINAL_ID")
	private Integer terminalId;

	@Column(name = "TID")
	private String tid;

	@OneToOne
	@JoinColumn(name = "CITY_ID")
	private City city;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "DESCRIPTION")
	private String description;

	public Terminals() {
		super();
	}

	public Terminals(Integer terminalId, String tid, City city, String location, String description) {
		super();
		this.terminalId = terminalId;
		this.tid = tid;
		this.city = city;
		this.location = location;
		this.description = description;
	}

	public Integer getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Integer terminalId) {
		this.terminalId = terminalId;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
