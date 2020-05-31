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
public class CRUDservice {

	@Autowired
	BuildingRepo buildingRepo;
	
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	PropertyRepo propertyRepo;
	
	
	// Building CRUD
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
	
	// Owner CRUD
	public Owner addOwner(Owner owner) {
		ownerRepo.save(owner);
		return owner;
	}
	
	public String deleteOwner(int id) {
		ownerRepo.delete(ownerRepo.getOne(id));
		return "Owner Deleted";
	}
	
	public List<Owner> getOwners(){
		return ownerRepo.findAll();
	}
	
	public Optional<Owner> getOwnerById(int id) {
		return ownerRepo.findById(id);
	}
	
	// Property CRUD
	public Property addProperty(Property property) {
		propertyRepo.save(property);
		return property;
	}
	
	public String deleteProperty(int id) {
		propertyRepo.delete(propertyRepo.getOne(id));
		return "Property Deleted";
	}
	
	public List<Property> getProperties(){
		return propertyRepo.findAll();
	}
	
	public Optional<Property> getPropertyById(int id) {
		return propertyRepo.findById(id);
	}
}
