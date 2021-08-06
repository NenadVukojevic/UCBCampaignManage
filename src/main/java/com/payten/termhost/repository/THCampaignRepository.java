package com.payten.termhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.payten.termhost.model.THCampaign;

public interface THCampaignRepository extends JpaRepository<THCampaign, Integer> {
	@Query("SELECT c.campaignId, "
			+ "c.campaignName, "
			+ "c.campaignStart, "
			+ "c.campaignEnd, "
			+ "c.campaignDescription, "
			+ "c.campaignStatus, "
			+ "c.campaignText "
			+ " FROM THCampaign c, CampaignRule r "
			+ "WHERE c.campaignId = r.campaignId "
			+ "  AND r.externalId = :id")
    THCampaign getTHCampaignByExternalId(@Param("id") String id);
	
	THCampaign getTHCampaignByCampaignId(Integer campaignId);
}
