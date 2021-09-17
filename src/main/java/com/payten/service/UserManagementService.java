package com.payten.service;

import java.util.List;

import com.payten.termhost.user.management.model.Group;
import com.payten.termhost.user.management.model.Role;
import com.payten.termhost.user.management.model.User;
import com.payten.termhost.user.management.model.dto.GroupDTO;
import com.payten.termhost.user.management.model.dto.UserDTO;

public interface UserManagementService {
	List<Role> getListOfRoles();

	List<Group> getListOfGroups();

	GroupDTO getGroup(Integer id);

	GroupDTO save(GroupDTO groupDTO);

	GroupDTO getInitGroup();

	void deleteRole(Integer id);

	Role getRole(Integer id);

	Role saveRole(Role role);

	List<User> getListOfUsers();

	UserDTO getUser(Integer id);

	UserDTO getUserInit();

	UserDTO addUser(UserDTO user);

	void deleteGroup(Integer id);
}
