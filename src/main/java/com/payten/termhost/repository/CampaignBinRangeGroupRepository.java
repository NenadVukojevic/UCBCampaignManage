package com.payten.termhost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.model.offus.CampaignBinRangeGroup;
import com.payten.termhost.model.offus.CampaignBinRangeGroupId;

public interface CampaignBinRangeGroupRepository extends JpaRepository<CampaignBinRangeGroup, CampaignBinRangeGroupId> {
	List<CampaignBinRangeGroup> findByCampaignId(Integer campaignId);
}
