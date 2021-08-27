package com.payten.termhost.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.payten.termhost.model.offus.TerminalGroupMembers;
import com.payten.termhost.model.offus.TerminalGroupMembersId;

public interface TerminalGroupMembersRepository extends CrudRepository<TerminalGroupMembers, TerminalGroupMembersId>{
	List<TerminalGroupMembers> findByTerminalGroupId(Integer terminalGroupId);
}
