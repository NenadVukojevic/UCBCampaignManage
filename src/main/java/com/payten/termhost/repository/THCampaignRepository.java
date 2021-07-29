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
			+ "a.image, "
			+ "a.imageId, "
			+ "a.mimeType, "
			+ "c.campaignStatus, "
			+ "c.campaignText,"
			+ "c.btn1, "
			+ "c.btn2, "
			+ "c.btn3, "
			+ "c.btn4, "
			+ "c.btn5, "
			+ "c.btn6, "
			+ "c.btn7, "
			+ "c.btn8"
			+ " FROM THCampaign c, CampaignRule r, AtmBackground a "
			+ "WHERE c.campaignId = r.campaignId "
			+ "  AND c.atmBackground.imageId = a.imageId"
			+ "  AND r.externalId = :id")
    THCampaign getTHCampaignByExternalId(@Param("id") String id);
	
	THCampaign getTHCampaignByCampaignId(Integer campaignId);
}
