package com.payten.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.payten.crm.model.CRMResponse;
import com.payten.termhost.model.AtmBackground;
import com.payten.termhost.model.ButtonLabel;
import com.payten.termhost.model.CampaignRule;
import com.payten.termhost.model.OnUSCampaignDTO;
import com.payten.termhost.model.THCampaign;
import com.payten.termhost.repository.AtmBackgroundRepository;
import com.payten.termhost.repository.ButtonLabelRepository;
import com.payten.termhost.repository.CampaignRuleRepository;
import com.payten.termhost.repository.THCampaignRepository;

@Service
public class THService implements ITHService {

	private final THCampaignRepository thCampaignRepository;
	private final CampaignRuleRepository campaignRuleRepository;
	private final AtmBackgroundRepository atmBackgroundRepository;
	private final ButtonLabelRepository buttonLabelRepository;

	@Autowired
	public THService(THCampaignRepository thCampaignRepository
			       , CampaignRuleRepository campaignRuleRepository
			       , AtmBackgroundRepository atmBackgroundRepository
			       , ButtonLabelRepository buttonLabelRepository) {
		this.thCampaignRepository = thCampaignRepository;
		this.campaignRuleRepository = campaignRuleRepository;
		this.atmBackgroundRepository = atmBackgroundRepository;
		this.buttonLabelRepository = buttonLabelRepository;
	}

	@Override
	public List<THCampaign> getListOfTHCampaigns() {
		// TODO Auto-generated method stub
		return thCampaignRepository.findAll();
	}

	@Override
	public OnUSCampaignDTO getTHCampaingByExternalID(String externalId) {
		// TODO Auto-generated method stub
		THCampaign campaign = null;
		OnUSCampaignDTO result = new OnUSCampaignDTO();
		CampaignRule rule = campaignRuleRepository.getCampaignRUleByExternalId(externalId);
		if (rule != null) {
			campaign = thCampaignRepository.getTHCampaignByCampaignId(rule.getCampaignId());
		} else {
			campaign = new THCampaign();
		}

		result.setCampaignId(campaign.getCampaignId());
		result.setCampaignName(campaign.getCampaignName());
		result.setCampaignStart(campaign.getCampaignStart());
		result.setCampaignEnd(campaign.getCampaignEnd());
		result.setCampaignText(campaign.getCampaignText());
		result.setCampaignDescription(campaign.getCampaignDescription());

		result.setF1(campaign.getBtn1() != null ? campaign.getBtn1().getButtonLabelCode() : "");
		result.setF2(campaign.getBtn2() != null ? campaign.getBtn2().getButtonLabelCode() : "");
		result.setF3(campaign.getBtn3() != null ? campaign.getBtn3().getButtonLabelCode() : "");
		result.setF4(campaign.getBtn4() != null ? campaign.getBtn4().getButtonLabelCode() : "");
		result.setF5(campaign.getBtn5() != null ? campaign.getBtn5().getButtonLabelCode() : "");
		result.setF6(campaign.getBtn6() != null ? campaign.getBtn6().getButtonLabelCode() : "");
		result.setF7(campaign.getBtn7() != null ? campaign.getBtn7().getButtonLabelCode() : "");
		result.setF8(campaign.getBtn8() != null ? campaign.getBtn8().getButtonLabelCode() : "");

		result.setImageId(campaign.getAtmBackground() != null ? campaign.getAtmBackground().getImageId() : 0);

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
	public THCampaign saveCampaign(OnUSCampaignDTO campaign, String crmCampaignId, List<CRMResponse> responses) {
		THCampaign newTHCampaign = new THCampaign();

		if (campaign.getCampaignId() != null) {
			// update existing
			THCampaign oldTHCampaign = thCampaignRepository.getOne(campaign.getCampaignId());
			if(oldTHCampaign != null)
			{
				newTHCampaign.setCampaignId(oldTHCampaign.getCampaignId());
			}
		}
		newTHCampaign.setCampaignName(campaign.getCampaignName());
		newTHCampaign.setCampaignDescription(campaign.getCampaignDescription());
		newTHCampaign.setCampaignText(campaign.getCampaignText());
		newTHCampaign.setCampaignStart(campaign.getCampaignStart());
		newTHCampaign.setCampaignEnd(campaign.getCampaignEnd());

		newTHCampaign.setAtmBackground(atmBackgroundRepository.getOne(campaign.getImageId()));

		newTHCampaign.setBtn1(getButtonId(campaign.getF1(), responses));
		newTHCampaign.setBtn2(getButtonId(campaign.getF2(), responses));
		newTHCampaign.setBtn3(getButtonId(campaign.getF3(), responses));
		newTHCampaign.setBtn4(getButtonId(campaign.getF4(), responses));
		newTHCampaign.setBtn5(getButtonId(campaign.getF5(), responses));
		newTHCampaign.setBtn6(getButtonId(campaign.getF6(), responses));
		newTHCampaign.setBtn7(getButtonId(campaign.getF7(), responses));
		newTHCampaign.setBtn8(getButtonId(campaign.getF8(), responses));

		newTHCampaign = thCampaignRepository.save(newTHCampaign);
		
		saveCampaignRule(newTHCampaign.getCampaignId(), crmCampaignId);
		
		return newTHCampaign;
	}

	private void saveCampaignRule(Integer campaingId, String externalId)
	{
		CampaignRule campaignRule = campaignRuleRepository.getCampaignRUleByExternalId(externalId);
		if(campaignRule == null)
		{
			campaignRule = new CampaignRule();
			campaignRule.setExternalId(externalId);
		}
		
		campaignRule.setCampaignId(campaingId);
		
		campaignRule = campaignRuleRepository.save(campaignRule);
	}
	
	private ButtonLabel getButtonId(String buttonCode, List<CRMResponse> responses)
	{
		// if code is not set
		// 
		if(buttonCode.equals(""))
		{
			return null;
		}
		
		ButtonLabel buttonLabel = buttonLabelRepository.getButtonLabelByButtonLabelCode(buttonCode);
		// buttonLabel not found in database
		// add new buttonLabel
		if(buttonLabel == null)
		{
			for (CRMResponse crmResponse : responses) {
				if(crmResponse.getResponseId().equals(buttonCode))
				{
					buttonLabel = new ButtonLabel();
					buttonLabel.setButtonLabelCode(buttonCode);
					buttonLabel.setButtonLabelText(crmResponse.getResponseName());
					buttonLabel = buttonLabelRepository.save(buttonLabel);
					break;
				}
			}
		}
		return buttonLabel;
	}


	
}
