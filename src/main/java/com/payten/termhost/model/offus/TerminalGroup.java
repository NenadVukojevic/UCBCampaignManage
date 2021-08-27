package com.payten.termhost.model.offus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TERMINAL_GROUP")
public class TerminalGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DB_ID_GEN")
	@SequenceGenerator(name = "DB_ID_GEN", sequenceName = "TERMINAL_GROUP_ID_SEQ", allocationSize = 1)
	@Column(name = "TERMINAL_GROUP_ID")
	private Integer terminalGroupId;

	@Column(name = "TERMINAL_GROUP_NAME")
	private String terminalGroupName;

	public TerminalGroup() {
		super();
	}

	public TerminalGroup(Integer terminalGroupId, String terminalGroupName) {
		super();
		this.terminalGroupId = terminalGroupId;
		this.terminalGroupName = terminalGroupName;
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

}
