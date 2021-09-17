package com.payten.termhost.user.management.model.dto;

import com.payten.termhost.user.management.model.Group;

public class UserGroupDTO {
	private Integer groupId;
	private String description;
	private String groupname;
	private Boolean in;

	public UserGroupDTO() {
		super();
	}

	public UserGroupDTO(Group group, Boolean in)
	{
		this.groupId = group.getGroupId();
		this.description = group.getDescription();
		this.groupname = group.getGroupname();
		this.in = in;
	}
	
	public UserGroupDTO(Integer groupId, String description, String groupname, Boolean in) {
		super();
		this.groupId = groupId;
		this.description = description;
		this.groupname = groupname;
		this.in = in;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Boolean getIn() {
		return in;
	}

	public void setIn(Boolean in) {
		this.in = in;
	}

}
