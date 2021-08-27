package com.payten.service;

import java.util.List;

import com.payten.termhost.model.offus.TerminalGroup;
import com.payten.termhost.model.offus.dto.TerminalDTO;
import com.payten.termhost.model.offus.dto.TerminalGroupDTO;

public interface TerminalsService {
	List<TerminalDTO> getListOfTerminals();

	List<TerminalGroup> getListOfTerminalGroups();

	TerminalGroupDTO getTerminalGroup(Integer id);

	TerminalGroupDTO insertTerminalGroup(TerminalGroupDTO groupDTO);

	TerminalGroupDTO updateTerminalGroup(TerminalGroupDTO groupDTO);
	
}
