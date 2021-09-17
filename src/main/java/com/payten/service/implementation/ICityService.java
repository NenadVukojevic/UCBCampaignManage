package com.payten.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payten.service.CityService;
import com.payten.termhost.model.offus.City;
import com.payten.termhost.repository.CityRepository;

@Service
public class ICityService implements CityService {

	@Autowired
	CityRepository cityRepository;
	
	@Override
	public List<City> getListOfCities() {
		// TODO Auto-generated method stub
		return cityRepository.findAll();
	}

}
