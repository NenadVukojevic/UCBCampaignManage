package com.payten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payten.termhost.model.THCampaign;
import com.payten.termhost.repository.THCampaignRepository;

@Service
public class THService implements ITHService {

	private final THCampaignRepository thCampaignRepository;
	
	@Autowired
	public THService(THCampaignRepository thCampaignRepository) {
		this.thCampaignRepository = thCampaignRepository;
	}
	
	@Override
	public List<THCampaign> getListOfTHCampaigns() {
		// TODO Auto-generated method stub
		return thCampaignRepository.findAll();
	}

}
