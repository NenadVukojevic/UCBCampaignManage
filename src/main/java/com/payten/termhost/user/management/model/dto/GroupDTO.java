package com.payten.termhost.user.management.model.dto;

import java.util.HashSet;
import java.util.Set;

import com.payten.termhost.user.management.model.Group;

public class GroupDTO {
	private Integer groupId;
	private String description;
	private String groupname;
	private Set<RoleDTO> roles;

	public GroupDTO() {
		super();
		this.roles = new HashSet<RoleDTO>();
	}

	public GroupDTO(Group group) {
		super();
		this.groupId = group.getGroupId();
		this.groupname = group.getGroupname();
		this.description = group.getDescription();
		this.roles = new HashSet<RoleDTO>();
	}

	public GroupDTO(Integer groupid, String description, String groupname, Set<RoleDTO> roles) {
		super();
		this.groupId = groupid;
		this.description = description;
		this.groupname = groupname;
		this.roles = roles;
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

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "GroupDTO [groupId=" + groupId + ", description=" + description + ", groupname=" + groupname + ", roles="
				+ roles + "]";
	}

}
