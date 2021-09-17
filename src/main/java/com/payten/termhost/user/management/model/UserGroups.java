package com.payten.termhost.user.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "USER_GROUPS")
@IdClass(UserGroupId.class)
public class UserGroups {
	@Id
	@Column(name = "USER_ID")
	private Integer userId;
	@Id
	@Column(name = "GROUP_ID")
	private Integer groupId;

	public UserGroups() {
		super();
	}

	public UserGroups(Integer userId, Integer groupId) {
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

}
