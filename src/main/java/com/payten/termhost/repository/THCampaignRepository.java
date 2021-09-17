package com.payten.termhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.payten.termhost.model.THCampaign;

public interface THCampaignRepository extends JpaRepository<THCampaign, Integer> {
    THCampaign getTHCampaignByExternalId(@Param("id") String id);
	
	THCampaign getTHCampaignByCampaignId(Integer campaignId);
}
