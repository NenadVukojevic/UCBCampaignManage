package com.payten.termhost.user.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_ID_GEN")
	@SequenceGenerator(name = "ROLE_ID_GEN", sequenceName = "ROLES_ID_SEQ", allocationSize = 1)
	@Column(name = "ROLE_ID")
	private Integer roleId;

	@Column(name = "ROLENAME")
	private String rolename;

	@Column(name = "DESCRIPTION")
	private String description;

	public Role() {
		super();
	}

	public Role(Integer roleId, String rolename, String description) {
		super();
		this.roleId = roleId;
		this.rolename = rolename;
		this.description = description;
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

}
