package com.payten.service;

import java.util.List;

import com.payten.termhost.model.CampaignStatus;
import com.payten.termhost.model.offus.OffUsResponses;
import com.payten.termhost.model.offus.OffUsResponsesDTO;
import com.payten.termhost.model.offus.dto.OffUsCampaignDTO;

public interface IOffUsCampaignsService {
	List<OffUsCampaignDTO> getCampaigns();
	List<OffUsResponses> getResponses();
	OffUsResponses saveResponse(OffUsResponses response);
	OffUsResponses updateResponse(OffUsResponses response);
	OffUsResponses getResponse(Integer id);
	List<CampaignStatus> getStatuses();
	List<OffUsResponsesDTO> getResponsesDTO();
	OffUsCampaignDTO insertCampaign(OffUsCampaignDTO campaign);
	OffUsCampaignDTO getCampaign(Integer id);
}
