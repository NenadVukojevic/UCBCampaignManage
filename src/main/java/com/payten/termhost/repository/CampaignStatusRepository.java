package com.payten.termhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.termhost.model.CampaignStatus;

public interface CampaignStatusRepository extends JpaRepository<CampaignStatus, Integer> {

}
