package com.payten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payten.service.UserManagementService;
import com.payten.termhost.user.management.model.Group;
import com.payten.termhost.user.management.model.Role;
import com.payten.termhost.user.management.model.User;
import com.payten.termhost.user.management.model.dto.GroupDTO;
import com.payten.termhost.user.management.model.dto.UserDTO;

@CrossOrigin("*") // (origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user/management")
public class UserManagementController {

	@Autowired
	UserManagementService userManagementService;
	
	@GetMapping("/roles")
	List<Role> getListOfRoles()
	{
		return userManagementService.getListOfRoles();
	}
	
	@GetMapping("/roles/{id}")
	Role getRole(@PathVariable Integer id)
	{
		return userManagementService.getRole(id);
	}
	
	@PostMapping("/roles")
	Role saveRole(@RequestBody Role role)
	{
		return userManagementService.saveRole(role);
	}
	
	@DeleteMapping("/roles/{id}")
	void deleteRole(@PathVariable Integer id)
	{
		userManagementService.deleteRole(id);
	}
	
	@GetMapping("/groups")
	List<Group> getListOfGroups()
	{
		return userManagementService.getListOfGroups();
	}
	
	@GetMapping("/group/{id}")
	GroupDTO getGroup(@PathVariable Integer id)
	{
		return userManagementService.getGroup(id);
	}
	
	@GetMapping("/group/init")
	GroupDTO getInitGroup()
	{
		return userManagementService.getInitGroup();
	}
	
	@PostMapping("/group")
	GroupDTO saveGroup(@RequestBody GroupDTO groupDTO)
	{
		GroupDTO saved = userManagementService.save(groupDTO);
		return saved;
	}
	
	@DeleteMapping("/group/{id}")
	void deleteGroup(@PathVariable Integer id)
	{
		userManagementService.deleteGroup(id);
	}
	
	@GetMapping("/user")
	List<User> getListOfUsers(){
		return userManagementService.getListOfUsers();
	}
	
	@GetMapping("/user/{id}")
	UserDTO getUser(@PathVariable Integer id) {
		return userManagementService.getUser(id);
	}
	
	@GetMapping("/user/init")
	UserDTO getUserInit() {
		return userManagementService.getUserInit();
	}
	
	@PostMapping("/user")
	UserDTO addUser(@RequestBody UserDTO user)
	{
		return userManagementService.addUser(user);
	}
}
