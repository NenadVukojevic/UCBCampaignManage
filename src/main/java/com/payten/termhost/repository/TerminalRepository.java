package com.payten.termhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.model.offus.Terminals;

public interface TerminalRepository extends JpaRepository<Terminals, Integer>{

}
