package com.payten.termhost.user.management.model;

import java.io.Serializable;
import java.util.Objects;

public class UserGroupId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5899571326927239921L;
	private Integer userId;
	private Integer groupId;

	public UserGroupId() {
		super();
	}

	public UserGroupId(Integer userId, Integer groupId) {
		super();
		this.userId = userId;
		this.groupId = groupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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

		UserGroupId userGroupId = (UserGroupId) o;

		return userId.equals(userGroupId.userId) && groupId.equals(userGroupId.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupId, userId);
	}

}
