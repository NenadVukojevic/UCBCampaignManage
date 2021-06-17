package com.payten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payten.crm.model.CRMCampaign;
import com.payten.crm.model.CRMResponse;
import com.payten.service.ICRMService;
import com.payten.service.ITHService;
import com.payten.termhost.model.THCampaign;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class CampaignController {
	

	@Autowired
	public ICRMService crmService;
	
	@Autowired
	public ITHService thService;
	

	@GetMapping("/campaignsCRM")
	List<CRMCampaign> getCampaignList() {
		return crmService.getCRMCampaignList();
	}


	@GetMapping("/responseCRM/{id}")
	List<CRMResponse> getResponses(@PathVariable String id)
	{
		return crmService.getCRMResponsesForCampaign(id);
	}
	
	@GetMapping("/campaignsTH")
	List<THCampaign> getTHCampaignList() {
		return thService.getListOfTHCampaigns();
	}
}
