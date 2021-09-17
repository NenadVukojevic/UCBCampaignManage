package com.payten.termhost.user.management.model.dto;

import com.payten.termhost.user.management.model.Role;

public class RoleDTO {
	private Integer roleId;
	private String rolename;
	private String description;
	private boolean in;
	
	
	public RoleDTO() {
		super();
	}

	public RoleDTO(Role role, boolean in)
	{
		this.roleId = role.getRoleId();
		this.rolename = role.getRolename();
		this.description = role.getDescription();
		this.in = in;
	}

	public RoleDTO(Integer roleId, String rolename, String description, boolean in) {
		super();
		this.roleId = roleId;
		this.rolename = rolename;
		this.description = description;
		this.in = in;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
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

	@Override
	public String toString() {
		return "RoleDTO [roleId=" + roleId + ", rolename=" + rolename + ", description=" + description + ", in=" + in
				+ "]";
	}
	
	
	
}
