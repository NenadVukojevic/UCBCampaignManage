package com.payten.termhost.user.management.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.payten.termhost.user.management.model.User;

public class UserDTO {
	private Integer userId;
	private String username;
	private String email;
	private String password;
	private Boolean isApproved;
	private String fullName;

	private List<UserGroupDTO> groups;

	public UserDTO() {
		super();
		this.groups = new ArrayList<UserGroupDTO>();
	}

	public UserDTO(User user) {
		this.userId = user.getUserId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.fullName = user.getFullName();
		this.isApproved = user.getIsApproved() == 1 ? true : false;

		this.groups = new ArrayList<UserGroupDTO>();
	}

	public UserDTO(Integer userId, String username, String email, String password, Integer isApproved, String fullName,
			List<UserGroupDTO> groups) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isApproved = isApproved == 1 ? true : false;
		this.fullName = fullName;
		this.groups = groups;
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

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<UserGroupDTO> getGroups() {
		return groups;
	}

	public void setGroups(List<UserGroupDTO> groups) {
		this.groups = groups;
	}

}
