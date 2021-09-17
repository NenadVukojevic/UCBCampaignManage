package com.payten.termhost.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payten.termhost.user.management.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
