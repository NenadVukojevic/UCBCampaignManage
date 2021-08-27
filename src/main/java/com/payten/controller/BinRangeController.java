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

import com.payten.service.IBinRangeService;
import com.payten.termhost.model.offus.BinRange;
import com.payten.termhost.model.offus.BinRangeGroup;
import com.payten.termhost.model.offus.dto.BinRangeGroupDTO;

@CrossOrigin("*") // (origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/api/v1/binRanges")
public class BinRangeController {
	
	@Autowired
	IBinRangeService binRangeService;
	
	@GetMapping("/groups")
	List<BinRangeGroup> getBinRangesGroups(){
		return binRangeService.getListOfBinRangeGroups();
	}
	
	@GetMapping("/groups/{id}")
	BinRangeGroupDTO getBinRangeGroup(@PathVariable Integer id) {
		return binRangeService.getBinRangeGroup(id);
	}
	
	@PostMapping("/groups")
	BinRangeGroupDTO addBinRangeGroup(@RequestBody BinRangeGroupDTO groupDTO)
	{
		return binRangeService.addBinRangeGroup(groupDTO);
	}
	
	@PutMapping("/groups")
	BinRangeGroupDTO updateBinRangeGroup(@RequestBody BinRangeGroupDTO groupDTO)
	{
		return binRangeService.updateBinRangeGroup(groupDTO);
	}
	
	
	
	
	@GetMapping("/")
	List<BinRange> getListOfBinRanges()
	{
		return binRangeService.getListOfBinRanges();
	}

}
