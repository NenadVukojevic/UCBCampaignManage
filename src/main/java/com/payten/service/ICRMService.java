package com.payten.service;

import java.util.List;

import com.payten.crm.model.CRMCampaign;
import com.payten.crm.model.CRMResponse;

public interface ICRMService {
	List<CRMCampaign> getCRMCampaignList();
	List<CRMResponse> getCRMResponsesForCampaign(String campaignId);
}
