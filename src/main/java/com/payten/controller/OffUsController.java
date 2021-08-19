package com.payten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payten.service.IOffUsCampaignsService;
import com.payten.termhost.model.CampaignStatus;
import com.payten.termhost.model.offus.OffUsResponses;
import com.payten.termhost.model.offus.OffUsResponsesDTO;
import com.payten.termhost.model.offus.dto.OffUsCampaignDTO;

@CrossOrigin("*") // (origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/off")
public class OffUsController {

	@Autowired
	IOffUsCampaignsService offUsCampaignsService;
	
	@GetMapping(path="/")
	List<OffUsCampaignDTO> getCampaignList()
	{
		List<OffUsCampaignDTO> campaigns = offUsCampaignsService.getCampaigns();
		
		return campaigns;
	}
	
	
	@GetMapping(path="/{id}")
	OffUsCampaignDTO getCampaign(@PathVariable Integer id) {
		return offUsCampaignsService.getCampaign(id);
	}
	
	@GetMapping(path="/responses")
	List<OffUsResponses> getResponses()
	{
		return offUsCampaignsService.getResponses();
	}
	
	@GetMapping(path="/responsesDTO")
	List<OffUsResponsesDTO> getResponsesDTO()
	{
		return offUsCampaignsService.getResponsesDTO();
	}
	
	@GetMapping(path="/responses/{id}")
	OffUsResponses getResponse(@PathVariable Integer id) {
		return offUsCampaignsService.getResponse(id);
	}
	
	@PostMapping(path="/responses")
	OffUsResponses addOffUsResponse(@RequestBody OffUsResponses response) {
		OffUsResponses savedResponse = offUsCampaignsService.saveResponse(response);
		return savedResponse;
	}
	
	@PutMapping(path="/responses")
	OffUsResponses updateOffUsResponse(@RequestBody OffUsResponses response) {
		OffUsResponses savedResponse = offUsCampaignsService.updateResponse(response);
		return savedResponse;
	}
	
	@GetMapping("/statuses")
	List<CampaignStatus> getStatuses(){
		return offUsCampaignsService.getStatuses();
	}
	
	
	@PostMapping(path="/")
	OffUsCampaignDTO addOffUsCampaign(@RequestBody OffUsCampaignDTO campaign) 
	{
		OffUsCampaignDTO response = offUsCampaignsService.insertCampaign(campaign);
		return response;
	}
}
