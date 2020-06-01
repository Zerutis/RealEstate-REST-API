package com.zerutis.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerutis.task.dao.BuildingRepo;
import com.zerutis.task.dao.OwnerRepo;
import com.zerutis.task.dao.PropertyRepo;
import com.zerutis.task.model.Building;
import com.zerutis.task.model.Owner;
import com.zerutis.task.model.Property;

@Service
public class BuildingService {
	
	@Autowired
	BuildingRepo buildingRepo;
	
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	PropertyRepo propertyRepo;
	
	public Building addBuilding(Building building, int owner_id, int property_id)
	{
		Owner owner = ownerRepo.findById(owner_id).orElse(new Owner());
		Property property = propertyRepo.findById(property_id).orElse(new Property());
		building.setOwner(owner);
		building.setProperty(property);
		buildingRepo.save(building);
		return building;
	}
	
	public String deleteBuilding(int id) {
		buildingRepo.delete(buildingRepo.getOne(id));
		return "Building Deleted";
	}
	
	public List<Building> getBuildings(){
		return buildingRepo.findAll();
	}
	
	public Optional<Building> getBuildingById(int id) {
		return buildingRepo.findById(id);
	}
	
}
