package com.payten.termhost.model.offus.dto;

import java.util.List;

public class TerminalGroupDTO {
	private Integer terminalGroupId;
	private String terminalGroupName;

	private List<Integer> members;

	public TerminalGroupDTO() {
		super();
	}

	public TerminalGroupDTO(Integer terminalGroupId, String terminalGroupName, List<Integer> members) {
		super();
		this.terminalGroupId = terminalGroupId;
		this.terminalGroupName = terminalGroupName;
		this.members = members;
	}

	public Integer getTerminalGroupId() {
		return terminalGroupId;
	}

	public void setTerminalGroupId(Integer terminalGroupId) {
		this.terminalGroupId = terminalGroupId;
	}

	public String getTerminalGroupName() {
		return terminalGroupName;
	}

	public void setTerminalGroupName(String terminalGroupName) {
		this.terminalGroupName = terminalGroupName;
	}

	public List<Integer> getMembers() {
		return members;
	}

	public void setMembers(List<Integer> members) {
		this.members = members;
	}

}
