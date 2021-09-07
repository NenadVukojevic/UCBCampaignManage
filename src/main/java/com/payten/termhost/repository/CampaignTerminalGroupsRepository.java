package com.payten.termhost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.model.offus.CampaignTerminalGroupId;
import com.payten.termhost.model.offus.CampaignTerminalGroups;

public interface CampaignTerminalGroupsRepository
		extends JpaRepository<CampaignTerminalGroups, CampaignTerminalGroupId> {
	List<CampaignTerminalGroups> findByCampaignId(Integer Id);
}
