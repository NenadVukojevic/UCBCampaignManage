package com.payten.termhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer>{
	ApplicationUser getApplicationUserByUsername(String username);
}
