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

import com.payten.service.CityService;
import com.payten.service.TerminalsService;
import com.payten.termhost.model.offus.City;
import com.payten.termhost.model.offus.TerminalGroup;
import com.payten.termhost.model.offus.dto.TerminalDTO;
import com.payten.termhost.model.offus.dto.TerminalGroupDTO;


@CrossOrigin("*") // (origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/api/v1")
public class TerminalsController {

	@Autowired
	TerminalsService terminalsService;
	
	@Autowired
	CityService cityService;
	
	@GetMapping("/terminals")
	List<TerminalDTO> getListOfTerminals()
	{
		return terminalsService.getListOfTerminals();
	}
	
	@GetMapping("/terminal/{id}")
	TerminalDTO getTerminal(@PathVariable Integer id)
	{
		TerminalDTO  response =  new TerminalDTO(terminalsService.getTerminal(id));
		return response;
	}
	
	@GetMapping("/terminalGroup")
	List<TerminalGroup> getListOfTerminalGroups()
	{
		return terminalsService.getListOfTerminalGroups();
	}
	
	@GetMapping("/terminalGroup/{id}")
	TerminalGroupDTO getTerminalGroup(@PathVariable Integer id)
	{
		return terminalsService.getTerminalGroup(id);
	}
	
	@PostMapping("/terminalGroup")
	TerminalGroupDTO insertTerminalGroup(@RequestBody TerminalGroupDTO groupDTO)
	{
		TerminalGroupDTO result = terminalsService.insertTerminalGroup(groupDTO);
				
		return result;
	}
	
	@PutMapping("/terminalGroup")
	TerminalGroupDTO updateTerminalGroup(@RequestBody TerminalGroupDTO groupDTO)
	{
		TerminalGroupDTO result = terminalsService.updateTerminalGroup(groupDTO);
				
		return result;
	}
	
	@GetMapping("/terminals/cities")
	List<City> getCities(){
		return cityService.getListOfCities();
	}
	
	@PostMapping("/terminal")
	TerminalDTO addTerminal(@RequestBody TerminalDTO terminal)
	{
		TerminalDTO response = terminalsService.addTerminal(terminal);
		return response;
	}
}
