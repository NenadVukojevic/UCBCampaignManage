package com.payten.termhost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class ApplicationUser {
	@Id
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "IS_APPROVED")
	private Integer isApproved;

	@Column(name = "FULL_NAME")
	private String fullName;

	public ApplicationUser() {
		super();
	}

	public ApplicationUser(Integer userId, String username, String email, String password, Integer isApproved,
			String fullName) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isApproved = isApproved;
		this.fullName = fullName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Integer isApproved) {
		this.isApproved = isApproved;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
