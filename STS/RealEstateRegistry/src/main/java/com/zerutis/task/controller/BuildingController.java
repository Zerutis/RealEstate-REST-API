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

import com.zerutis.task.dao.BuildingRepo;
import com.zerutis.task.model.Building;
import com.zerutis.task.service.SearchService;

@RestController
public class BuildingController
{
	@Autowired
	BuildingRepo repo;
	
	@Autowired
	SearchService SearchS;
	
	@PostMapping(path="/building", consumes = {"application/json"})
	public Building addBuilding(@RequestBody Building building)
	{
		repo.save(building);
		return building;
	}
	
	@PutMapping(path="/building", consumes = {"application/json"})
	public Building saveOrUpdateBuilding(@RequestBody Building building)
	{
		repo.save(building);
		return building;
	}
	
	@DeleteMapping("/building/{id}")
	public String deleteBuilding(@PathVariable("id") int id)
	{
		Building building = repo.getOne(id);
		
		repo.delete(building);
		
		return "Building deleted";
	}
	
	@GetMapping("/buildings")
	public List<Building> getBuildings()
	{
		return repo.findAll();
	}
	
	@GetMapping("/building/{id}")
	public Optional<Building> getBuilding(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
	
	@GetMapping("/building/similar/{city}/{street}/{number}/{property_type}/{size}")
	public List<Building> getSimilarBuildings(
			@PathVariable("city") String city,
			@PathVariable("street") String street,
			@PathVariable("number") int number,
			@PathVariable("property_type") String property_type,
			@PathVariable("size") double size)
	{
		return SearchS.getSimilarBuilding(repo.findAll(), city, street, number, property_type, size);
	}
	

}
