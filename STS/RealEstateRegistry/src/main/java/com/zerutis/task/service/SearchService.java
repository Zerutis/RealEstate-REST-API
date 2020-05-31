package com.zerutis.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerutis.task.dao.BuildingRepo;
import com.zerutis.task.dao.OwnerRepo;
import com.zerutis.task.dao.PropertyRepo;
import com.zerutis.task.model.Building;



@Service
public class SearchService {
	
	@Autowired
	BuildingRepo buildingRepo;
	
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	PropertyRepo propertyRepo;
	
	
	
	public List<Building> getBuildingsGreater(double value)
	{
		return buildingRepo.findByValueGreaterThanSorted(value);
	}
	
	public List<Building> getSimilarBuildings(String city, String street, String property_type){
		return buildingRepo.findByParam(city, street, property_type);
	}
}
