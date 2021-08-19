package com.payten.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payten.termhost.model.CampaignStatus;
import com.payten.termhost.model.offus.OffUsCampaign;
import com.payten.termhost.model.offus.OffUsDefinitions;
import com.payten.termhost.model.offus.OffUsResponses;
import com.payten.termhost.model.offus.OffUsResponsesDTO;
import com.payten.termhost.model.offus.dto.OffUsCampaignDTO;
import com.payten.termhost.model.offus.dto.OffUsDefinitionsDTO;
import com.payten.termhost.repository.AtmBackgroundRepository;
import com.payten.termhost.repository.CampResolutionRepository;
import com.payten.termhost.repository.CampaignStatusRepository;
import com.payten.termhost.repository.offus.OffUsCampaignRepository;
import com.payten.termhost.repository.offus.OffUsDefinitionsRepository;
import com.payten.termhost.repository.offus.OffUsResponsesRepository;

@Service
public class OffUsCampaignsService implements IOffUsCampaignsService {

	@Autowired
	OffUsCampaignRepository offUsCampaignRepository;

	@Autowired
	OffUsResponsesRepository offUsResponsesRepository;

	@Autowired
	OffUsDefinitionsRepository offUsDefinitionsRepository;

	@Autowired
	CampaignStatusRepository campaignStatusRepository;

	@Autowired
	AtmBackgroundRepository atmBackgroundRepository;

	@Autowired
	CampResolutionRepository campResolutionRepository;

	@Override
	public List<OffUsCampaignDTO> getCampaigns() {
		List<OffUsCampaign> campaigns = offUsCampaignRepository.findAll();

		List<OffUsCampaignDTO> result = new ArrayList<OffUsCampaignDTO>();

		for (OffUsCampaign offUsCampaign : campaigns) {
			// we are returning list of campaign for display as list
			// there is no need to pass definitions here
			// hence withDefinitions param = false
			OffUsCampaignDTO campaign = convertCampaign(offUsCampaign, false);

			result.add(campaign);

		}
		return result;
	}

	private OffUsCampaignDTO convertCampaign(OffUsCampaign campaign, boolean withDefinitions) {
		OffUsCampaignDTO result = new OffUsCampaignDTO();
		result.setCampaignId(campaign.getCampaignId());
		result.setCampaignDescription(campaign.getCampaignDescription());
		result.setCampaignName(campaign.getCampaignName());
		result.setCampaignStart(campaign.getCampaignStart());
		result.setCampaignEnd(campaign.getCampaignEnd());
		result.setCampaignText(campaign.getCampaignText());
		result.setCollectingText(campaign.getCollectingText());

		result.setCampaignStatus(campaign.getCampaignStatus().getStatusId());

		result.setContactCollecting(campaign.isContactCollecting());

		if (withDefinitions) {
			List<OffUsDefinitionsDTO> definitions = new ArrayList<OffUsDefinitionsDTO>();
			for (OffUsDefinitions offUssDefinitions : campaign.getDefinitions()) {
				OffUsDefinitionsDTO newDefinitionsDTO = convertDefinition(offUssDefinitions);
				definitions.add(newDefinitionsDTO);
			}
			result.setDefinitions(definitions);
		}

		return result;
	}

	private OffUsCampaign convertCampaignDTO(OffUsCampaignDTO campaignDTO) {
		
		OffUsCampaign campaign = null;
		if(campaignDTO.getCampaignId() == null)
			//or campaignDto.getCampaignId() == 0)
		{
			campaign = new OffUsCampaign();
		}
		else
		{
			campaign = offUsCampaignRepository.getOne(campaignDTO.getCampaignId());
			System.out.println("convertCampaignDTO: get by ID " + campaignDTO.getCampaignId() + " :->" + campaign.toString()) ;
		}
		
		
		campaign.setCampaignName(campaignDTO.getCampaignName());
		campaign.setCampaignDescription(campaignDTO.getCampaignDescription());
		campaign.setCampaignStart(campaignDTO.getCampaignStart());
		campaign.setCampaignEnd(campaignDTO.getCampaignEnd());
		campaign.setCampaignText(campaignDTO.getCampaignText());
		campaign.setContactCollecting(campaignDTO.isContactCollecting());
		campaign.setCollectingText(campaignDTO.getCollectingText());
		campaign.setCampaignStatus(campaignStatusRepository.getOne(campaignDTO.getCampaignStatus()));
		campaign.setCampaignId(campaignDTO.getCampaignId());

		/*
		for (OffUsDefinitionsDTO definitionDTO : campaignDTO.getDefinitions()) {
			OffUsDefinitions newDefinition = convertDefinitionsDTO(definitionDTO);
			System.out.println(newDefinition);
			campaign.getDefinitions().add(newDefinition);
		}
		*/
		return campaign;
	}

	private OffUsDefinitions convertDefinitionsDTO(OffUsDefinitionsDTO definitionDTO) {
		
		OffUsDefinitions definitions = null;
		
		System.out.println("convertDefinitionsDTO: " + definitionDTO.getDefinitionId());
		
		if(definitionDTO.getDefinitionId() == 0)
		{
			definitions = new OffUsDefinitions();
		}
		else
		{
			definitions = offUsDefinitionsRepository.getOne(definitionDTO.getDefinitionId());
			System.out.println("Definition with id: " + definitionDTO.getDefinitionId()  +  " from database" +  definitions);
		}
		
		//definitions.setCampDefinitionId(definitionDTO.getDefinitionId());

		if (definitionDTO.getF1() != 0) {
			definitions.setBtn1(offUsResponsesRepository.getOne(definitionDTO.getF1()));
		}
		if (definitionDTO.getF2() != 0) {
			definitions.setBtn2(offUsResponsesRepository.getOne(definitionDTO.getF2()));
		}

		if (definitionDTO.getF3() != 0) {
			definitions.setBtn3(offUsResponsesRepository.getOne(definitionDTO.getF3()));
		}

		if (definitionDTO.getF4() != 0) {
			definitions.setBtn4(offUsResponsesRepository.getOne(definitionDTO.getF4()));
		}

		if (definitionDTO.getF5() != 0) {
			definitions.setBtn5(offUsResponsesRepository.getOne(definitionDTO.getF5()));
		}

		if (definitionDTO.getF6() != 0) {
			definitions.setBtn6(offUsResponsesRepository.getOne(definitionDTO.getF6()));
		}

		if (definitionDTO.getF7() != 0) {
			definitions.setBtn7(offUsResponsesRepository.getOne(definitionDTO.getF7()));
		}
		if (definitionDTO.getF8() != 0) {
			definitions.setBtn8(offUsResponsesRepository.getOne(definitionDTO.getF8()));
		}

		definitions.setResolution(campResolutionRepository.getOne(definitionDTO.getResolutionId()));

		if (definitionDTO.getImageId() != 0) {
			definitions.setAtmBackground(atmBackgroundRepository.getOne(definitionDTO.getImageId()));
		}

		return definitions;
	}

	private OffUsDefinitionsDTO convertDefinition(OffUsDefinitions offUsDefinitions) {
		OffUsDefinitionsDTO dto = new OffUsDefinitionsDTO();


		dto.setResolutionId(offUsDefinitions.getResolution().getResolutionId());
		
		dto.setDefinitionId(offUsDefinitions.getCampDefinitionId());

		if (offUsDefinitions.getAtmBackground() != null) {
			dto.setImageId(offUsDefinitions.getAtmBackground().getImageId());
		} else {
			dto.setImageId(0);
		}

		if (offUsDefinitions.getBtn1() != null) {
			dto.setF1(offUsDefinitions.getBtn1().getResponseId());
		} else {
			dto.setF1(0);
		}

		if (offUsDefinitions.getBtn2() != null) {
			dto.setF2(offUsDefinitions.getBtn2().getResponseId()	);
		} else {
			dto.setF2(0);
		}

		if (offUsDefinitions.getBtn3() != null) {
			dto.setF3(offUsDefinitions.getBtn3().getResponseId());
		} else {
			dto.setF3(0);
		}

		if (offUsDefinitions.getBtn4() != null) {
			dto.setF4(offUsDefinitions.getBtn4().getResponseId());
		} else {
			dto.setF4(0);
		}

		if (offUsDefinitions.getBtn5() != null) {
			dto.setF5(offUsDefinitions.getBtn5().getResponseId());
		} else {
			dto.setF5(0);
		}

		if (offUsDefinitions.getBtn6() != null) {
			dto.setF6(offUsDefinitions.getBtn6().getResponseId());
		} else {
			dto.setF6(0);
		}

		if (offUsDefinitions.getBtn7() != null) {
			dto.setF7(offUsDefinitions.getBtn7().getResponseId());
		} else {
			dto.setF7(0);
		}

		if (offUsDefinitions.getBtn8() != null) {
			dto.setF8(offUsDefinitions.getBtn8().getResponseId());
		} else {
			dto.setF8(0);
		}

		return dto;
	}

	@Override
	public List<OffUsResponses> getResponses() {

		return offUsResponsesRepository.findAll();
	}

	@Override
	public List<OffUsResponsesDTO> getResponsesDTO() {
		List<OffUsResponsesDTO> result = new ArrayList<OffUsResponsesDTO>();
		for (OffUsResponses response : offUsResponsesRepository.findAll()) {
			OffUsResponsesDTO responseDTO = new OffUsResponsesDTO();
			responseDTO.setResponseId(response.getResponseId());
			responseDTO.setResponseName(response.getResponseLabel());
			result.add(responseDTO);
		}
		return result;
	}

	@Override
	public OffUsResponses saveResponse(OffUsResponses response) {
		return offUsResponsesRepository.save(response);
	}

	@Override
	public OffUsResponses updateResponse(OffUsResponses response) {
		OffUsResponses existingResponse = offUsResponsesRepository.getOne(response.getResponseId());
		if (existingResponse == null) {
			System.out.println("raise error!!!!");
		}

		existingResponse.setConfirmation(response.isConfirmation());
		existingResponse.setResponseCode(response.getResponseCode());
		existingResponse.setResponseLabel(response.getResponseLabel());

		OffUsResponses savedResponse = offUsResponsesRepository.save(existingResponse);

		return savedResponse;
	}

	@Override
	public OffUsResponses getResponse(Integer id) {

		return offUsResponsesRepository.getOne(id);
	}

	@Override
	public List<CampaignStatus> getStatuses() {
		// TODO Auto-generated method stub
		return campaignStatusRepository.findAll();
	}

	@Override
	public OffUsCampaignDTO insertCampaign(OffUsCampaignDTO campaign) {
		System.out.println(campaign);
		OffUsCampaign newCampaign = convertCampaignDTO(campaign);
		OffUsCampaign savedCampaign = offUsCampaignRepository.save(newCampaign);
		
		
		for (OffUsDefinitionsDTO definitionDTO : campaign.getDefinitions()) {
			OffUsDefinitions newDefinition = convertDefinitionsDTO(definitionDTO);
			System.out.println(newDefinition);
			savedCampaign.getDefinitions().add(newDefinition);
		}

		savedCampaign = offUsCampaignRepository.save(savedCampaign);
		
		OffUsCampaignDTO result = convertCampaign(savedCampaign, true);
		return result;
	}

	@Override
	public OffUsCampaignDTO getCampaign(Integer id) {
		OffUsCampaign campaign = offUsCampaignRepository.getOne(id);
		OffUsCampaignDTO result = convertCampaign(campaign, true);
		return result;
	}
	
	
}
