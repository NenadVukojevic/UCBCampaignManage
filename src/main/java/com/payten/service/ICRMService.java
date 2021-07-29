package com.payten.service;

import java.util.List;

import com.payten.crm.model.CRMCampaign;
import com.payten.crm.model.CRMCampaignDto;
import com.payten.crm.model.CRMResponse;

public interface ICRMService {
	List<CRMCampaignDto> getCRMCampaignList();
	List<CRMResponse> getCRMResponsesForCampaign(String campaignId);
	CRMCampaign getCRMCampaign(String campaignId);
}
