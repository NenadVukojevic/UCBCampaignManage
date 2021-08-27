package com.payten.termhost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.model.offus.BinRangeGroupMember;
import com.payten.termhost.model.offus.BinRangeGroupMemberId;

public interface BinRangeGroupMemberRepository extends JpaRepository<BinRangeGroupMember, BinRangeGroupMemberId>{
	List<BinRangeGroupMember> findByBinRangeGroupId(Integer binRangeGroupId);

}
