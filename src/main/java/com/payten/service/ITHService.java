package com.payten.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.payten.crm.model.CRMCampaign;
import com.payten.crm.model.CRMResponse;
import com.payten.termhost.model.AtmBackground;
import com.payten.termhost.model.CampaignDTO;
import com.payten.termhost.model.OnUSCampaignDTO;
import com.payten.termhost.model.THCampaign;

public interface ITHService {
	List<THCampaign> getListOfTHCampaigns();
	OnUSCampaignDTO getTHCampaingByExternalID(String externalId);
	CampaignDTO getCampaingByExternaelID(CRMCampaign crmCampaign);
	AtmBackground getAtmBackground(Integer id);
	AtmBackground insertAtmBackground(MultipartFile file);
	THCampaign saveCampaign(CampaignDTO campaign, String crmCampaignId, List<CRMResponse> responses);
}
