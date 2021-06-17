package com.payten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payten.crm.model.CRMCampaign;
import com.payten.crm.model.CRMResponse;
import com.payten.crm.repository.CRMCampaignRepository;
import com.payten.crm.repository.CRMResponseRepository;

@Service
public class CRMService implements ICRMService {

	private final CRMCampaignRepository crmRepository;
	private final CRMResponseRepository crmResponseRepository;
	
	@Autowired
	public CRMService(CRMCampaignRepository crmRepository, CRMResponseRepository crmResponseRepository) {
		this.crmRepository = crmRepository;
		this.crmResponseRepository = crmResponseRepository;
	}
	@Override
	public List<CRMCampaign> getCRMCampaignList() {
		// TODO Auto-generated method stub
		return crmRepository.findAll();
	}

	@Override
	public List<CRMResponse> getCRMResponsesForCampaign(String campaignId) {
		// TODO Auto-generated method stub
		return crmResponseRepository.findByCampaignId(campaignId);
	}

}
