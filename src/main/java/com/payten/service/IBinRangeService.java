package com.payten.service;

import java.util.List;

import com.payten.termhost.model.offus.BinRange;
import com.payten.termhost.model.offus.BinRangeGroup;
import com.payten.termhost.model.offus.dto.BinRangeGroupDTO;

public interface IBinRangeService {

	List<BinRangeGroup> getListOfBinRangeGroups();

	BinRangeGroupDTO getBinRangeGroup(Integer id);

	List<BinRange> getListOfBinRanges();

	BinRangeGroupDTO addBinRangeGroup(BinRangeGroupDTO groupDTO);

	BinRangeGroupDTO updateBinRangeGroup(BinRangeGroupDTO groupDTO);

}
