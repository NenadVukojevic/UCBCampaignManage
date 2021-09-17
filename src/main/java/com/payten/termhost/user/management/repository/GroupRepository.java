package com.payten.termhost.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.user.management.model.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {
	Group getGroupByGroupname(String groupName);
}
