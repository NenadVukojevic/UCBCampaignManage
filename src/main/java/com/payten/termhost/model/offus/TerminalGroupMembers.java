package com.payten.termhost.model.offus;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "TERMINAL_GROUP_MEMBERS")
@IdClass(TerminalGroupMembersId.class)
public class TerminalGroupMembers implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 728843863619416249L;
	@Id
	@Column(name = "TERMINAL_GROUP_ID")
	private Integer terminalGroupId;
	@Id
	@Column(name = "TERMINAL_ID")
	private Integer terminalId;

	public TerminalGroupMembers() {
		super();
	}

	public TerminalGroupMembers(Integer terminalGroupId, Integer terminalId) {
		super();
		this.terminalGroupId = terminalGroupId;
		this.terminalId = terminalId;
	}

	public Integer getTerminalGroupId() {
		return terminalGroupId;
	}

	public void setTerminalGroupId(Integer terminalGroupId) {
		this.terminalGroupId = terminalGroupId;
	}

	public Integer getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Integer terminalId) {
		this.terminalId = terminalId;
	}

	@Override
	public String toString() {
		return "TerminalGroupMembers [terminalGroupId=" + terminalGroupId + ", terminalId=" + terminalId + "]";
	}

}
