package com.zerutis.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerutis.task.dao.BuildingRepo;
import com.zerutis.task.model.Building;

@Service
public class BuildingService {
	
	@Autowired
	BuildingRepo buildingRepo;
	
	public Building addBuilding(Building building) {
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
