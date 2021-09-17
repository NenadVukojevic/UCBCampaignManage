package com.payten.service.implementation;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.payten.crm.model.CRMCampaign;
import com.payten.crm.model.CRMResponse;
import com.payten.service.ITHService;
import com.payten.termhost.model.AtmBackground;
import com.payten.termhost.model.ButtonLabel;
import com.payten.termhost.model.CampResolution;
import com.payten.termhost.model.CampaignDTO;
import com.payten.termhost.model.CampaignDefinitionDTO;
import com.payten.termhost.model.CampaignDefinitions;
import com.payten.termhost.model.CampaignStatus;
import com.payten.termhost.model.OnUSCampaignDTO;
import com.payten.termhost.model.THCampaign;
import com.payten.termhost.repository.AtmBackgroundRepository;
import com.payten.termhost.repository.ButtonLabelRepository;
import com.payten.termhost.repository.CampResolutionRepository;
import com.payten.termhost.repository.CampaignDefinitionRepository;
import com.payten.termhost.repository.CampaignRuleRepository;
import com.payten.termhost.repository.CampaignStatusRepository;
import com.payten.termhost.repository.THCampaignRepository;

@Service
public class THService implements ITHService {

	@Autowired
	CampaignStatusRepository campaignStatusRepository;

	@Autowired
	THCampaignRepository thCampaignRepository;
	
	@Autowired
	CampaignRuleRepository campaignRuleRepository;
	
	@Autowired
	AtmBackgroundRepository atmBackgroundRepository;
	
	@Autowired
	ButtonLabelRepository buttonLabelRepository;
	
	@Autowired
	CampaignDefinitionRepository campaignDefinitionRepository;
	
	@Autowired
	CampResolutionRepository campResolutionRepository;

	@Override
	public List<THCampaign> getListOfTHCampaigns() {
		// TODO Auto-generated method stub
		return thCampaignRepository.findAll();
	}

	@Override
	public OnUSCampaignDTO getTHCampaingByExternalID(String externalId) {
		// TODO Auto-generated method stub
		THCampaign campaign = thCampaignRepository.getTHCampaignByExternalId(externalId);

		OnUSCampaignDTO result = new OnUSCampaignDTO();
		if (campaign == null) {

			campaign = new THCampaign();
			campaign.setExteranalId(externalId);
		} else {
			result.setCampaignId(campaign.getCampaignId());
			result.setCampaignName(campaign.getCampaignName());
			result.setCampaignStatus(campaign.getCampaignStatus().getStatusId());
			result.setCampaignText(campaign.getCampaignText());
			result.setCampaignDescription(campaign.getCampaignDescription());
		}
		return result;
	}

	@Override
	public AtmBackground getAtmBackground(Integer id) {
		// TODO Auto-generated method stub
		return atmBackgroundRepository.getOne(id);
	}

	@Override
	public AtmBackground insertAtmBackground(MultipartFile file) {
		// TODO Auto-generated method stub
		AtmBackground image = new AtmBackground();
		try {
			image.setImage(file.getBytes());
			image.setMimeType(file.getContentType());
			System.out.println(file.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return atmBackgroundRepository.save(image);
	}

	@Override
	public THCampaign saveCampaign(CampaignDTO campaign, String crmCampaignId, List<CRMResponse> responses) {
		THCampaign newTHCampaign = new THCampaign();

		if (campaign.getCampaignId() != null) {
			// update existing
			THCampaign oldTHCampaign = thCampaignRepository.getOne(campaign.getCampaignId());
			if (oldTHCampaign != null) {
				newTHCampaign.setCampaignId(oldTHCampaign.getCampaignId());
			}
		}
		newTHCampaign.setCampaignName(campaign.getCampaignName());
		newTHCampaign.setCampaignDescription(campaign.getCampaignDescription());
		newTHCampaign.setCampaignText(campaign.getCampaignText());
		newTHCampaign.setCampaignStart(campaign.getCampaignStart());
		newTHCampaign.setCampaignEnd(campaign.getCampaignEnd());
		newTHCampaign.setContactCollecting(campaign.isContactCollecting());
		newTHCampaign.setExteranalId(crmCampaignId);

		newTHCampaign = thCampaignRepository.save(newTHCampaign);

		for (CampaignDefinitionDTO definition : campaign.getDefinitions()) {
			if (definition.getCampaignId() == 0) {
				definition.setCampaignId(newTHCampaign.getCampaignId());
			}

			saveDefinition(definition, responses);
		}

		return newTHCampaign;
	}

	private void saveDefinition(CampaignDefinitionDTO definition, List<CRMResponse> responses) {

		if (definition.getImageId() == 0) {
			return;
		}

		CampaignDefinitions newDefinition = new CampaignDefinitions();
		if (definition.getDefinitionId() != 0) {
			newDefinition = campaignDefinitionRepository.getOne(definition.getDefinitionId());
		}

		AtmBackground background = atmBackgroundRepository.getOne(definition.getImageId());
		CampResolution resolution = campResolutionRepository.getOne(definition.getResolutionId());

		ButtonLabel b1 = getButtonId(definition.getF1(), responses);
		ButtonLabel b2 = getButtonId(definition.getF2(), responses);
		ButtonLabel b3 = getButtonId(definition.getF3(), responses);
		ButtonLabel b4 = getButtonId(definition.getF4(), responses);
		ButtonLabel b5 = getButtonId(definition.getF5(), responses);
		ButtonLabel b6 = getButtonId(definition.getF6(), responses);
		ButtonLabel b7 = getButtonId(definition.getF7(), responses);
		ButtonLabel b8 = getButtonId(definition.getF8(), responses);

		newDefinition.setCampaignId(definition.getCampaignId());
		newDefinition.setAtmBackground(background);
		newDefinition.setResolution(resolution);

		newDefinition.setBtn1(b1);
		newDefinition.setBtn2(b2);
		newDefinition.setBtn3(b3);
		newDefinition.setBtn4(b4);
		newDefinition.setBtn5(b5);
		newDefinition.setBtn6(b6);
		newDefinition.setBtn7(b7);
		newDefinition.setBtn8(b8);

		campaignDefinitionRepository.save(newDefinition);
	}

	private ButtonLabel getButtonId(String buttonCode, List<CRMResponse> responses) {

		// if code is not set //
		if (buttonCode == null || buttonCode.equals("")) {
			return null;
		}

		System.out.println(buttonCode);
		ButtonLabel buttonLabel = buttonLabelRepository.getButtonLabelByButtonLabelCode(buttonCode);

		// buttonLabel not found in database
		// add new buttonLabel
		if (buttonLabel == null) {
			for (CRMResponse crmResponse : responses) {
				System.out.println(crmResponse.toString());
				if (crmResponse.getResponseId().equals(buttonCode)) {
					buttonLabel = new ButtonLabel();
					buttonLabel.setButtonLabelCode(buttonCode);
					buttonLabel.setButtonLabelText(crmResponse.getResponseName());
					buttonLabel = buttonLabelRepository.save(buttonLabel);
					System.out.println(buttonLabel.toString());
					break;
				}
			}
		} else {
			System.out.println(buttonLabel.toString());
		}
		return buttonLabel;
	}

	private CampaignStatus getStatusByDate(Date StartDate , Date endDate)
	{
		CampaignStatus status = new CampaignStatus();
		Date curr = Date.valueOf(LocalDate.now());
		if(curr.after(StartDate) && curr.before(endDate)) {
			status = campaignStatusRepository.getOne(1);
		}
		else
		{
			status = campaignStatusRepository.getOne(2);
		}
		return status;
	}

	@Override
	public CampaignDTO getCampaingByExternaelID(CRMCampaign crmCampaign) {
		THCampaign campaign = thCampaignRepository.getTHCampaignByExternalId(crmCampaign.getCampaignId());

		CampaignDTO result = new CampaignDTO();
		if (campaign == null) {
			campaign = new THCampaign();
			campaign.setCampaignDescription(crmCampaign.getCampaignDesc());
			campaign.setCampaignName(crmCampaign.getCampaignName());
			campaign.setCampaignStart(crmCampaign.getStartDate());
			campaign.setCampaignEnd(crmCampaign.getEndDate());
			campaign.setContactCollecting(false);
		}

		campaign.setCampaignStatus(getStatusByDate(crmCampaign.getStartDate(), crmCampaign.getEndDate()));

		result.setExternalId(crmCampaign.getCampaignId());

		result.setCampaignId(campaign.getCampaignId());
		if (campaign.getCampaignName() != null) {
			result.setCampaignName(campaign.getCampaignName());
		} else {
			result.setCampaignName(crmCampaign.getCampaignName());
		}

		if (campaign.getCampaignStart() != null) {
			result.setCampaignStart(campaign.getCampaignStart());
		} else {
			result.setCampaignStart(crmCampaign.getStartDate());
		}

		if (campaign.getCampaignEnd() != null) {
			result.setCampaignEnd(campaign.getCampaignEnd());
		} else {
			result.setCampaignEnd(crmCampaign.getEndDate());
		}

		if (campaign.getCampaignDescription() != null) {
			result.setCampaignDescription(campaign.getCampaignDescription());
		} else {
			result.setCampaignDescription(crmCampaign.getCampaignDesc());
		}

		if (campaign.getCampaignText() != null) {
			result.setCampaignText(campaign.getCampaignText());
		} else {
			result.setCampaignText("");
		}

		if(campaign.getCampaignStatus() != null) {
			result.setCampaignStatus(campaign.getCampaignStatus().getStatusName());
		}
		
		result.setContactCollecting(campaign.isContactCollecting());

		List<CampaignDefinitionDTO> definitions = new ArrayList<CampaignDefinitionDTO>();

		if (campaign != null && campaign.getDefinitions() != null) {
			for (CampaignDefinitions definition : campaign.getDefinitions()) {
				CampaignDefinitionDTO cDefinition = new CampaignDefinitionDTO();
				cDefinition.setCampaignId(definition.getCampaignId());

				if (definition.getAtmBackground() != null) {
					cDefinition.setImageId(definition.getAtmBackground().getImageId());
				}

				if (definition.getResolution() != null) {
					cDefinition.setResolutionId(definition.getResolution().getResolutionId());
				}

				if (definition.getBtn1() != null) {
					cDefinition.setF1(definition.getBtn1().getButtonLabelCode());
				}

				if (definition.getBtn2() != null) {
					cDefinition.setF2(definition.getBtn2().getButtonLabelCode());
				}

				if (definition.getBtn3() != null) {
					cDefinition.setF3(definition.getBtn3().getButtonLabelCode());
				}

				if (definition.getBtn4() != null) {
					cDefinition.setF4(definition.getBtn4().getButtonLabelCode());
				}

				if (definition.getBtn5() != null) {
					cDefinition.setF5(definition.getBtn5().getButtonLabelCode());
				}

				if (definition.getBtn6() != null) {
					cDefinition.setF6(definition.getBtn7().getButtonLabelCode());
				}

				if (definition.getBtn7() != null) {
					cDefinition.setF7(definition.getBtn7().getButtonLabelCode());
				}

				if (definition.getBtn8() != null) {
					cDefinition.setF8(definition.getBtn8().getButtonLabelCode());
				}

				if (definition.getResolution() != null) {
					cDefinition.setResolutionId(definition.getResolution().getResolutionId());
				}

				cDefinition.setDefinitionId(definition.getDefinitionId());

				cDefinition.setCampaignText(campaign.getCampaignText());

				definitions.add(cDefinition);
				System.out.println(definition.toString());
			}
		}
		result.setDefinitions(definitions);

		System.out.println(crmCampaign.toString());
		System.out.println(result.toString());
		return result;
	}

}
