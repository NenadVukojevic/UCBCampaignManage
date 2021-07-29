package com.payten.termhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.model.CampaignRule;

public interface CampaignRuleRepository extends JpaRepository<CampaignRule, Integer>{
	CampaignRule getCampaignRUleByExternalId(String externalId);
}
