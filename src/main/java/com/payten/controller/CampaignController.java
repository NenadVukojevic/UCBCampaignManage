package com.payten.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.payten.crm.model.CRMCampaign;
import com.payten.crm.model.CRMCampaignDto;
import com.payten.crm.model.CRMResponse;
import com.payten.service.ICRMService;
import com.payten.service.ITHService;
import com.payten.termhost.model.AtmBackground;
import com.payten.termhost.model.CampaignDTO;
import com.payten.termhost.model.OnUSCampaignDTO;
import com.payten.termhost.model.THCampaign;

import crm.payten.model.CampaignDetailsDto;

@CrossOrigin("*") // (origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class CampaignController {

	@Autowired
	public ICRMService crmService;

	@Autowired
	public ITHService thService;

	@GetMapping("/campaignsCRM")
	List<CRMCampaignDto> getCampaignList() {
		return crmService.getCRMCampaignList();
	}

	@GetMapping("/responseCRM/{id}")
	List<CRMResponse> getResponses(@PathVariable String id) {
		return crmService.getCRMResponsesForCampaign(id);
	}

	@GetMapping("/campaignsTH")
	List<THCampaign> getTHCampaignList() {
		return thService.getListOfTHCampaigns();
	}

	@GetMapping("/campaignDetails/{id}")
	CampaignDetailsDto getCampaignDetails(@PathVariable String id) {
		CampaignDetailsDto details = new CampaignDetailsDto();

		details.setResponses(crmService.getCRMResponsesForCampaign(id));
		details.setCrmCampaign(crmService.getCRMCampaign(id));

		details.setThCampaign(thService.getTHCampaingByExternalID(id));

		return details;
	}

	@GetMapping("/campaign/{id}")
	CampaignDTO getCampaign(@PathVariable String id) {
		CRMCampaign crmCampaign = crmService.getCRMCampaign(id);
		return thService.getCampaingByExternaelID(crmCampaign);
	}
	
	@PostMapping("/campaigns/image")
	AtmBackground uploadImage(@RequestParam("file") MultipartFile file) {
		return thService.insertAtmBackground(file);
	}

	@RequestMapping(value = "/campaigns/image/{id}", method = RequestMethod.GET)
	public void getImage(@PathVariable("id") Integer id, HttpServletResponse response) throws Exception {
		AtmBackground atmBackground = thService.getAtmBackground(id);
		response.setContentType(atmBackground.getMimeType());
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(atmBackground.getImage());
		outputStream.flush();
		outputStream.close();
	}

	@GetMapping("/thCampaign/{id}")
	OnUSCampaignDTO getTHCampaignbyId(@PathVariable String id) {
		OnUSCampaignDTO campaign = thService.getTHCampaingByExternalID(id);

		return campaign;
	}

	
	@PutMapping(value = "/campaigns/{crmCampaignId}")
	public THCampaign saveCampaign(@RequestBody CampaignDTO campaign, @PathVariable String crmCampaignId) {
		List<CRMResponse> responses = crmService.getCRMResponsesForCampaign(crmCampaignId);
		
		THCampaign newCampaign = new THCampaign();
		System.out.println(responses);
		newCampaign = thService.saveCampaign(campaign, crmCampaignId, responses);
		return newCampaign;
	}
}
