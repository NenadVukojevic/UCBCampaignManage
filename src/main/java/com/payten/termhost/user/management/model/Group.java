package com.payten.termhost.user.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPS")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUP_ID_GEN")
	@SequenceGenerator(name = "GROUP_ID_GEN", sequenceName = "GROUPS_ID_SEQ", allocationSize = 1)
	@Column(name = "GROUP_ID")
	private Integer groupId;

	@Column(name = "GROUPNAME")
	private String groupname;

	@Column(name = "DESCRIPTION")
	private String description;

	public Group() {
		super();
	}

	public Group(Integer groupId, String groupname, String description) {
		super();
		this.groupId = groupId;
		this.groupname = groupname;
		this.description = description;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
