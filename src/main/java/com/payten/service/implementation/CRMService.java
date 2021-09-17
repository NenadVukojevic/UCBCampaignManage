package com.payten.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payten.crm.model.CRMCampaign;
import com.payten.crm.model.CRMCampaignDto;
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
	public List<CRMCampaignDto> getCRMCampaignList() {
		// TODO Auto-generated method stub
		List<CRMCampaign> crmCapmaigns = crmRepository.findAll();
		List<CRMCampaignDto> crmCampaignsDto = new ArrayList<CRMCampaignDto>();

		Date currentDate = new Date(System.currentTimeMillis());
		
		for (CRMCampaign crmCampaign : crmCapmaigns) {
			CRMCampaignDto crmCampaignDto = new CRMCampaignDto();
			
			crmCampaignDto.setCampaignId(crmCampaign.getCampaignId());
			crmCampaignDto.setCampaignName(crmCampaign.getCampaignName());
			crmCampaignDto.setCampaignDesc(crmCampaign.getCampaignDesc());
			crmCampaignDto.setEndDate(crmCampaign.getEndDate());
			crmCampaignDto.setStartDate(crmCampaign.getStartDate());
			
			if(crmCampaign.getStartDate().before(currentDate)  && crmCampaign.getEndDate().after(currentDate))
			{
				crmCampaignDto.setActive(true);
			}
			else
			{
				crmCampaignDto.setActive(false);
			}
			
			crmCampaignsDto.add(crmCampaignDto);
		}
		
		return crmCampaignsDto;
	}

	@Override
	public List<CRMResponse> getCRMResponsesForCampaign(String campaignId) {
		// TODO Auto-generated method stub
		return crmResponseRepository.findByCampaignId(campaignId);
	}
	
	@Override
	public CRMCampaign getCRMCampaign(String campaignId) {
		// TODO Auto-generated method stub
		return crmRepository.findByCampaignId(campaignId);
	}

}
