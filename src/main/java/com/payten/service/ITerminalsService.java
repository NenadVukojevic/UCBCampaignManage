package com.payten.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payten.termhost.model.offus.TerminalGroup;
import com.payten.termhost.model.offus.TerminalGroupMembers;
import com.payten.termhost.model.offus.Terminals;
import com.payten.termhost.model.offus.dto.TerminalDTO;
import com.payten.termhost.model.offus.dto.TerminalGroupDTO;
import com.payten.termhost.repository.CampaignBinRangeGroupRepository;
import com.payten.termhost.repository.TerminalGroupMembersRepository;
import com.payten.termhost.repository.TerminalGroupRepository;
import com.payten.termhost.repository.TerminalRepository;

@Service
public class ITerminalsService implements TerminalsService {

	@Autowired
	TerminalRepository terminalRepository;

	@Autowired
	TerminalGroupRepository terminalGroupRepository;

	@Autowired
	TerminalGroupMembersRepository terminalGroupMembersRepository;
	
	@Autowired
	CampaignBinRangeGroupRepository campaignBinRangeGroupRepository;

	@Override
	public List<TerminalDTO> getListOfTerminals() {
		List<TerminalDTO> response = new ArrayList<TerminalDTO>();

		List<Terminals> terminals = terminalRepository.findAll();
		for (Terminals terminal : terminals) {
			TerminalDTO terminalDTO = new TerminalDTO(terminal);
			response.add(terminalDTO);
		}

		return response;
	}

	@Override
	public List<TerminalGroup> getListOfTerminalGroups() {
		// TODO Auto-generated method stub
		return terminalGroupRepository.findAll();
	}

	@Override
	public TerminalGroupDTO getTerminalGroup(Integer id) {
		TerminalGroup group = terminalGroupRepository.getOne(id);
		List<TerminalGroupMembers> members = terminalGroupMembersRepository
				.findByTerminalGroupId(group.getTerminalGroupId());
		List<Integer> terminals = new ArrayList<Integer>();
		for (TerminalGroupMembers member : members) {
			terminals.add(member.getTerminalId());
		}

		TerminalGroupDTO response = new TerminalGroupDTO(group.getTerminalGroupId(), group.getTerminalGroupName(),
				terminals);
		return response;
	}

	@Override
	public TerminalGroupDTO insertTerminalGroup(TerminalGroupDTO groupDTO) {
		// TODO Auto-generated method stub
		TerminalGroup toSave = new TerminalGroup();
		toSave.setTerminalGroupName(groupDTO.getTerminalGroupName());

		toSave = terminalGroupRepository.save(toSave);

		for (Integer terminalId : groupDTO.getMembers()) {
			TerminalGroupMembers member = new TerminalGroupMembers(toSave.getTerminalGroupId(), terminalId);
			terminalGroupMembersRepository.save(member);
		}

		return getTerminalGroup(toSave.getTerminalGroupId());
	}

	@Override
	public TerminalGroupDTO updateTerminalGroup(TerminalGroupDTO groupDTO) {
		TerminalGroup toSave = terminalGroupRepository.getOne(groupDTO.getTerminalGroupId());
		toSave.setTerminalGroupName(groupDTO.getTerminalGroupName());

		List<TerminalGroupMembers> existingMembers = terminalGroupMembersRepository
				.findByTerminalGroupId(groupDTO.getTerminalGroupId());

		List<TerminalGroupMembers> changedMembers = new ArrayList<TerminalGroupMembers>();

		for (Integer terminalId : groupDTO.getMembers()) {
			TerminalGroupMembers member = new TerminalGroupMembers(toSave.getTerminalGroupId(), terminalId);
			changedMembers.add(member);
		}

		List<TerminalGroupMembers> removed = existingMembers.stream()
				.filter(o1 -> changedMembers.stream().noneMatch(o2 -> o2.getTerminalId().equals(o1.getTerminalId())))
				.collect(Collectors.toList());
		
		List<TerminalGroupMembers> added = changedMembers.stream()
				.filter(o1 -> existingMembers.stream().noneMatch(o2 -> o2.getTerminalId().equals(o1.getTerminalId())))
				.collect(Collectors.toList());


		for (TerminalGroupMembers terminalGroupMembers : removed) {
			terminalGroupMembersRepository.delete(terminalGroupMembers);
		}
		

		
		for (TerminalGroupMembers terminalGroupMembers : added) {
			terminalGroupMembersRepository.save(terminalGroupMembers);
		}

		return getTerminalGroup(toSave.getTerminalGroupId());
	}

}
