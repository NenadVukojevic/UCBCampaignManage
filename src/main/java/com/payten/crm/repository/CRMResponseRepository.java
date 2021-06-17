package com.payten.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payten.crm.model.CRMResponse;
import com.payten.crm.model.CRMResponseId;

public interface CRMResponseRepository extends JpaRepository<CRMResponse, CRMResponseId> {
	List<CRMResponse> findByCampaignId(String campaignId);
}
