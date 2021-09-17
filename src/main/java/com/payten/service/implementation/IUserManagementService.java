package com.payten.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payten.service.UserManagementService;
import com.payten.termhost.user.management.model.Group;
import com.payten.termhost.user.management.model.GroupRoles;
import com.payten.termhost.user.management.model.Role;
import com.payten.termhost.user.management.model.User;
import com.payten.termhost.user.management.model.UserGroups;
import com.payten.termhost.user.management.model.dto.GroupDTO;
import com.payten.termhost.user.management.model.dto.RoleDTO;
import com.payten.termhost.user.management.model.dto.UserDTO;
import com.payten.termhost.user.management.model.dto.UserGroupDTO;
import com.payten.termhost.user.management.repository.GroupRepository;
import com.payten.termhost.user.management.repository.GroupRoleRepository;
import com.payten.termhost.user.management.repository.RoleRepository;
import com.payten.termhost.user.management.repository.UserGroupRepository;
import com.payten.termhost.user.management.repository.UserRepository;

@Service
public class IUserManagementService implements UserManagementService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	GroupRoleRepository groupRoleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserGroupRepository userGroupRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public List<Role> getListOfRoles() {
		return roleRepository.findAll();
	}

	@Override
	public List<Group> getListOfGroups() {
		// TODO Auto-generated method stub
		return groupRepository.findAll();
	}

	@Override
	public GroupDTO getGroup(Integer id) {
		Group group = groupRepository.getOne(id);
		GroupDTO result = new GroupDTO(group);
		List<GroupRoles> usedRoles = groupRoleRepository.getGroupRolesByGroupId(id);
		List<Role> roles = roleRepository.findAll();
		for (Role role : roles) {
			boolean isIn = isIn(role, usedRoles);
			System.out.println(role + " - " + isIn);
			result.getRoles().add(new RoleDTO(role, isIn));
		}
		
		System.out.println(result);
		return result;
	}

	
	private boolean isIn(Role role, List<GroupRoles> usedRoles)
	{
		boolean response = false;
		
		for(GroupRoles groupRole: usedRoles) {
			if(groupRole.getRoleId() == role.getRoleId())
			{
				response = true;
				break;
			}
		}
		
		return response;
	}
	
	@Override
	public GroupDTO save(GroupDTO groupDTO) {
		Group group = new Group();
		group.setGroupId(groupDTO.getGroupId());
		group.setGroupname(groupDTO.getGroupname());
		group.setDescription(groupDTO.getDescription());
		
		group = groupRepository.save(group);
		
		List<GroupRoles> usedRoles = groupRoleRepository.getGroupRolesByGroupId(group.getGroupId());
		
		List<GroupRoles> changedRoles = new ArrayList<GroupRoles>();
		
		for(RoleDTO roleDTO: groupDTO.getRoles())
		{
			if(roleDTO.isIn()) {
				changedRoles.add(new GroupRoles(group.getGroupId(), roleDTO.getRoleId()));
			}
		}
		
		
		List<GroupRoles> removed = usedRoles.stream()
				.filter(o1 -> changedRoles.stream().noneMatch(o2 -> o2.getRoleId().equals(o1.getRoleId())))
				.collect(Collectors.toList());

		List<GroupRoles> added = changedRoles.stream()
				.filter(o1 -> usedRoles.stream().noneMatch(o2 -> o2.getRoleId().equals(o1.getRoleId())))
				.collect(Collectors.toList());
		
		for(GroupRoles groupRole: removed)
		{
			groupRoleRepository.delete(groupRole);
		}
		
		for(GroupRoles groupRole: added) {
			groupRoleRepository.save(groupRole);
		}
		
		GroupDTO response = getGroup(group.getGroupId());
		
		return response;
	}

	@Override
	public GroupDTO getInitGroup() {
		GroupDTO result = new GroupDTO();
		List<Role> roles = roleRepository.findAll();
		for (Role role : roles) {
			boolean isIn = false;
			System.out.println(role + " - " + isIn);
			result.getRoles().add(new RoleDTO(role, isIn));
		}
		return result;
	}

	@Override
	public void deleteRole(Integer id) {
		Role role = roleRepository.getOne(id);
		List<GroupRoles> groupRoles = groupRoleRepository.getGroupRolesByRoleId(id);
		for (GroupRoles groupRole : groupRoles) {
			groupRoleRepository.delete(groupRole);
		}
		roleRepository.delete(role);
	}

	@Override
	public Role getRole(Integer id) {
		
		return roleRepository.getOne(id);
	}

	@Override
	public Role saveRole(Role role) {

		return roleRepository.save(role);
	}

	@Override
	public List<User> getListOfUsers() {

		return userRepository.findAll();
	}

	private boolean isIn(Group group, List<UserGroups> userGroups)
	{
		boolean result = false;
		for(UserGroups userGroup: userGroups) {
			
			if(group.getGroupId() == userGroup.getGroupId())
			{
				result = true;
				break;
			}
		}
		
		
		return result;
	}
	
	@Override
	public UserDTO getUser(Integer id) {
		User user =userRepository.getOne(id); 
		UserDTO result = new UserDTO(user);
		
		List<UserGroups> userGroups = userGroupRepository.getUserGroupsByUserId(user.getUserId());
		List<Group> groups = groupRepository.findAll();
		for (Group group : groups) {
			result.getGroups().add(new UserGroupDTO(group, isIn(group, userGroups)));
		}
				
		return result;
	}

	@Override
	public UserDTO getUserInit() {
		UserDTO result = new UserDTO();
		List<Group> groups = groupRepository.findAll();
		for (Group group : groups) {
			result.getGroups().add(new UserGroupDTO(group, false));
		}
		return result;
	}

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByUserId(userDTO.getUserId());
		if(user == null)
		{
			user = new User();
			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		}
		else
		{
			System.out.println(user);
			// if password is changed 
			// we presume that it is sent in clear form
			if(!user.getPassword().equals(userDTO.getPassword()))
			{
				user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			}
		}
		user.setEmail(userDTO.getEmail());
		user.setFullName(userDTO.getFullName());
		user.setUsername(userDTO.getUsername());
		user.setIsApproved(userDTO.getIsApproved()?1:0);
		
		user = userRepository.save(user);
		
		List<UserGroups> usedGroups = userGroupRepository.getUserGroupsByUserId(user.getUserId());
		List<UserGroups> changedGroups = new ArrayList<UserGroups>();
		
		for(UserGroupDTO group: userDTO.getGroups())
		{
			if(group.getIn()) {
				changedGroups.add(new UserGroups(user.getUserId(), group.getGroupId()));
			}
		}
		
		List<UserGroups> removed = usedGroups.stream()
				.filter(o1 -> changedGroups.stream().noneMatch(o2 -> o2.getGroupId().equals(o1.getGroupId())))
				.collect(Collectors.toList());

		List<UserGroups> added = changedGroups.stream()
				.filter(o1 -> usedGroups.stream().noneMatch(o2 -> o2.getGroupId().equals(o1.getGroupId())))
				.collect(Collectors.toList());
		
		for(UserGroups userGroup: removed) {
			userGroupRepository.delete(userGroup);
		}
		
		for(UserGroups userGroup: added) {
			userGroupRepository.save(userGroup);
		}
		
		
		return getUser(user.getUserId());
	}

	@Override
	public void deleteGroup(Integer id) {
		Group group = groupRepository.getOne(id);
		
		List<UserGroups> userGroups = userGroupRepository.getUserGroupsByGroupId(id);
		for (UserGroups groups : userGroups) {
			userGroupRepository.delete(groups);
		}
		
		List<GroupRoles> groupRoles = groupRoleRepository.getGroupRolesByGroupId(id);
		for (GroupRoles groups : groupRoles) {
			groupRoleRepository.delete(groups);
		}
		
		groupRepository.delete(group);
	}
	
	

}
