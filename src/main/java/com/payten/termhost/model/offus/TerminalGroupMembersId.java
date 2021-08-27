package com.payten.termhost.model.offus;

import java.io.Serializable;
import java.util.Objects;

public class TerminalGroupMembersId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1909250167886381997L;
	
	private Integer terminalGroupId;
	private Integer terminalId;
	
	public TerminalGroupMembersId() {
		super();
	}

	public TerminalGroupMembersId(Integer terminalGroupId, Integer terminalId) {
		super();
		this.terminalGroupId = terminalGroupId;
		this.terminalId = terminalId;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		
		if(o == null || getClass() != o.getClass()) return false;
		
		TerminalGroupMembersId terminalGroupMemberId = (TerminalGroupMembersId) o;
		
		return terminalGroupId.equals(terminalGroupMemberId.terminalGroupId) &&
				terminalId.equals(terminalGroupMemberId.terminalId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(terminalGroupId, terminalId);
	}
	

}
