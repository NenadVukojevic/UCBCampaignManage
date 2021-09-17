package com.payten.termhost.model.offus.dto;

import com.payten.termhost.model.offus.Terminals;

public class TerminalDTO {
	private Integer terminalId;

	private String tid;

	private Integer cityId;

	private String cityName;

	private String location;

	private String description;

	private boolean in;

	public TerminalDTO() {
		super();
	}

	public TerminalDTO(Integer terminalId, String tid, Integer cityId, String cityName, String location,
			String description, boolean in) {
		super();
		this.terminalId = terminalId;
		this.tid = tid;
		this.cityId = cityId;
		this.cityName = cityName;
		this.location = location;
		this.description = description;
		this.in = in;
	}

	public TerminalDTO(Terminals terminal) {
		super();
		this.terminalId = terminal.getTerminalId();
		this.tid = terminal.getTid() != null ? terminal.getTid() : "";
		this.cityName = terminal.getCity() != null ? terminal.getCity().getCityName() : "";
		this.cityId = terminal.getCity() != null ? terminal.getCity().getCityId() : 0;
		this.description = terminal.getDescription() != null ? terminal.getDescription() : "";
		this.location = terminal.getLocation() != null ? terminal.getLocation() : "";
		this.in = false;
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public boolean isIn() {
		return in;
	}

	public void setIn(boolean in) {
		this.in = in;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}
