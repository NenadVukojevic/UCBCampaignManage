package com.payten.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payten.termhost.model.offus.BinRange;
import com.payten.termhost.model.offus.BinRangeGroup;
import com.payten.termhost.model.offus.BinRangeGroupMember;
import com.payten.termhost.model.offus.dto.BinRangeGroupDTO;
import com.payten.termhost.repository.BinRangeGroupMemberRepository;
import com.payten.termhost.repository.BinRangeGroupRepository;
import com.payten.termhost.repository.BinRangeRepository;

@Service
public class BinRangeService implements IBinRangeService {

	@Autowired
	BinRangeGroupRepository binRangeGroupRepository;

	@Autowired
	BinRangeGroupMemberRepository binRangeGroupMemberRepository;

	@Autowired
	BinRangeRepository binRangeRepository;

	@Override
	public List<BinRangeGroup> getListOfBinRangeGroups() {
		// TODO Auto-generated method stub
		return binRangeGroupRepository.findAll();
	}

	@Override
	public BinRangeGroupDTO getBinRangeGroup(Integer id) {
		BinRangeGroup binRangeGroup = binRangeGroupRepository.getOne(id);

		BinRangeGroupDTO result = new BinRangeGroupDTO();

		result.setBinRangeGroupId(binRangeGroup.getBinRangeGroupId());
		result.setBinRangeName(binRangeGroup.getBinRangeName());

		List<Integer> members = new ArrayList<Integer>();

		List<BinRangeGroupMember> groupMembers = binRangeGroupMemberRepository
				.findByBinRangeGroupId(binRangeGroup.getBinRangeGroupId());
		for (BinRangeGroupMember member : groupMembers) {
			members.add(member.getBinRangeId());
		}

		result.setMembers(members);

		return result;
	}

	@Override
	public List<BinRange> getListOfBinRanges() {
		// TODO Auto-generated method stub
		return binRangeRepository.findAll();
	}

	@Override
	public BinRangeGroupDTO addBinRangeGroup(BinRangeGroupDTO groupDTO) {
		BinRangeGroup group = new BinRangeGroup(groupDTO.getBinRangeGroupId(), groupDTO.getBinRangeName());
		group = binRangeGroupRepository.save(group);

		for (Integer binRangeId : groupDTO.getMembers()) {
			BinRangeGroupMember member = new BinRangeGroupMember(group.getBinRangeGroupId(), binRangeId);
			binRangeGroupMemberRepository.save(member);
		}

		return getBinRangeGroup(group.getBinRangeGroupId());
	}

	@Override
	public BinRangeGroupDTO updateBinRangeGroup(BinRangeGroupDTO groupDTO) {
		BinRangeGroup group = binRangeGroupRepository.getOne(groupDTO.getBinRangeGroupId());
		group.setBinRangeName(groupDTO.getBinRangeName());

		group = binRangeGroupRepository.save(group);

		List<BinRangeGroupMember> groupMembers = binRangeGroupMemberRepository
				.findByBinRangeGroupId(groupDTO.getBinRangeGroupId());
		List<BinRangeGroupMember> changedMembers = new ArrayList<BinRangeGroupMember>();
		for (Integer binRangeId : groupDTO.getMembers()) {
			BinRangeGroupMember member = new BinRangeGroupMember(group.getBinRangeGroupId(), binRangeId);
			changedMembers.add(member);
		}

		List<BinRangeGroupMember> removed = groupMembers.stream()
				.filter(o1 -> changedMembers.stream().noneMatch(o2 -> o2.getBinRangeId().equals(o1.getBinRangeId())))
				.collect(Collectors.toList());

		List<BinRangeGroupMember> added = changedMembers.stream()
				.filter(o1 -> groupMembers.stream().noneMatch(o2 -> o2.getBinRangeId().equals(o1.getBinRangeId())))
				.collect(Collectors.toList());

		for (BinRangeGroupMember binRangeGroupMember : removed) {
			binRangeGroupMemberRepository.delete(binRangeGroupMember);
		}

		for (BinRangeGroupMember binRangeGroupMember : added) {
			binRangeGroupMemberRepository.save(binRangeGroupMember);
		}

		return getBinRangeGroup(group.getBinRangeGroupId());
	}

}
