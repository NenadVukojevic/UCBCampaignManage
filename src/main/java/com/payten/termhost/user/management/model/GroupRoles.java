package com.payten.termhost.user.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "GROUP_ROLES")
@IdClass(GroupRoleId.class)
public class GroupRoles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8262374843755082544L;

	@Id
	@Column(name = "GROUP_ID")
	private Integer groupId;

	@Id
	@Column(name = "ROLE_ID")
	private Integer roleId;

	public GroupRoles() {
		super();
	}

	public GroupRoles(Integer groupId, Integer roleId) {
		super();
		this.groupId = groupId;
		this.roleId = roleId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
