package com.payten.termhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.model.CampaignDefinitions;

public interface CampaignDefinitionRepository extends JpaRepository<CampaignDefinitions, Integer>{

}
