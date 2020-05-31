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
	
	@PostMapping("/building")
	public Building addBuilding(@RequestBody Building building)
	{
		return buildingService.addBuilding(building);
	}
	
	@PutMapping("/building")
	public Building saveOrUpdateBuilding(@RequestBody Building building)
	{
		return buildingService.addBuilding(building);
	}
	
	@DeleteMapping("/building/{id}")
	public String deleteBuilding(@PathVariable("id") int id)
	{
		return buildingService.deleteBuilding(id);
	}
	
	@GetMapping("/buildings")
	public List<Building> getBuildings()
	{
		return buildingService.getBuildings();
	}
	
	@GetMapping("/building/{id}")
	public Optional<Building> getBuilding(@PathVariable("id") int id)
	{
		return buildingService.getBuildingById(id);
	}
	
	@GetMapping("/building/value/{value}")
	public List<Building> getBuildings(@PathVariable("value") double value)
	{
		return searchService.getBuildingsGreater(value);
	}
	
	@GetMapping("/building/similar")
	public List<Building> getSimilarBuildings(
			@RequestParam("city") String city,
			@RequestParam("street") String street,
			@RequestParam("property_type") String property_type)
	{
		return searchService.getSimilarBuildings(city, street, property_type);
	}
	
}
