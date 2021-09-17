package com.payten.termhost.user.management.model;

import java.io.Serializable;
import java.util.Objects;

public class GroupRoleId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7145802150690330563L;
	private Integer groupId;
	private Integer roleId;

	public GroupRoleId() {
		super();
	}

	public GroupRoleId(Integer groupId, Integer roleId) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		GroupRoleId groupRoleId = (GroupRoleId) o;

		return roleId.equals(groupRoleId.roleId) && groupId.equals(groupRoleId.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupId, roleId);
	}
}
