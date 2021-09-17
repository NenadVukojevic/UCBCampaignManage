package com.payten.termhost.user.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.user.management.model.UserGroupId;
import com.payten.termhost.user.management.model.UserGroups;

public interface UserGroupRepository extends JpaRepository<UserGroups, UserGroupId>{
	List<UserGroups> getUserGroupsByUserId(Integer Id);
	List<UserGroups> getUserGroupsByGroupId(Integer Id);
}
