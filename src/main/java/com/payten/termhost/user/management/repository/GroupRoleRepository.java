package com.payten.termhost.user.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.user.management.model.GroupRoleId;
import com.payten.termhost.user.management.model.GroupRoles;

public interface GroupRoleRepository extends JpaRepository<GroupRoles, GroupRoleId> {
	List<GroupRoles> getGroupRolesByGroupId(Integer Id);
	List<GroupRoles> getGroupRolesByRoleId(Integer Id);
	
}
