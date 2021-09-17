package com.payten.termhost.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payten.termhost.user.management.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User getUserByUserId(Integer id);
}
