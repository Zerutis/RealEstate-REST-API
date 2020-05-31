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
import org.springframework.web.bind.annotation.RestController;

import com.zerutis.task.model.Building;
import com.zerutis.task.service.CRUDservice;
import com.zerutis.task.service.SearchService;

@RestController
public class BuildingController
{
	@Autowired
	CRUDservice crudService;
	
	@Autowired
	SearchService searchService;
	
	@PostMapping("/building")
	public Building addBuilding(@RequestBody Building building)
	{
		return crudService.addBuilding(building);
	}
	
	@PutMapping("/building")
	public Building saveOrUpdateBuilding(@RequestBody Building building)
	{
		return crudService.addBuilding(building);
	}
	
	@DeleteMapping("/building/{id}")
	public String deleteBuilding(@PathVariable("id") int id)
	{
		return crudService.deleteBuilding(id);
	}
	
	@GetMapping("/buildings")
	public List<Building> getBuildings()
	{
		return crudService.getBuildings();
	}
	
	@GetMapping("/building/{id}")
	public Optional<Building> getBuilding(@PathVariable("id") int id)
	{
		return crudService.getBuildingById(id);
	}
	
	@GetMapping("/building/value/{value}")
	public List<Building> getBuildings(@PathVariable("value") double value)
	{
		return searchService.getBuildingsGreater(value);
	}
	

	
}
