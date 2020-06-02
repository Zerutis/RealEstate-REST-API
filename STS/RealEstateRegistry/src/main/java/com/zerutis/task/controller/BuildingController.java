package com.zerutis.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zerutis.task.exception.ApiRequestException;
import com.zerutis.task.model.Building;
import com.zerutis.task.service.BuildingService;
import com.zerutis.task.service.SearchService;

@RestController
public class BuildingController
{
	@Autowired
	BuildingService buildingService;

	@Autowired
	SearchService searchService;
	
	@PostMapping("/building/{owner_id}/{property_id}")
	public Building addBuilding(
			@RequestBody Building building,
			@PathVariable("owner_id") int owner_id,
			@PathVariable("property_id") int property_id)
	{
		return buildingService.addBuilding(building, owner_id, property_id);
	}
	
	@PutMapping("/building/{owner_id}/{property_id}")
	public Building saveOrUpdateBuilding(
			@RequestBody Building building,
			@PathVariable("owner_id") int owner_id,
			@PathVariable("property_id") int property_id)
	{
		return buildingService.addBuilding(building, owner_id, property_id);
	}
	
	@DeleteMapping("/building/{id}")
	public String deleteBuilding(@PathVariable("id") int id)
	{
		return buildingService.deleteBuilding(id);
	}
	
	@GetMapping("/buildings")
	public List<Building> getBuildings()
	{
		List<Building> buildings = buildingService.getBuildings();
		if (buildings.isEmpty()) {
			throw new ApiRequestException("There is no buildings");
		}
		return buildings;
	}
	
	@GetMapping("/building/{id}")
	public Optional<Building> getBuilding(@PathVariable("id") int id)
	{
		Optional<Building> building = buildingService.getBuildingById(id);
		if (building.isEmpty()) {
			throw new ApiRequestException("There is no building by ID: " + id);
		}
		
		return building;
	}
	
	@GetMapping("/building/similar")
	public List<Building> getSimilarBuildings(
			@RequestParam("city") String city,
			@RequestParam("street") String street,
			@RequestParam("property_type") String property_type,
			@RequestParam("size") double size)
	{
		return searchService.getSimilarBuildings(city, street, property_type, size);
	}
	
}
