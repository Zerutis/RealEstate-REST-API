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

import com.zerutis.task.dao.PropertyRepo;
import com.zerutis.task.model.Property;

@RestController
public class PropertyController {

	@Autowired
	PropertyRepo repo;
	
	@PostMapping(path="/property", consumes = {"application/json"})
	public Property addProperty(@RequestBody Property property)
	{
		repo.save(property);
		return property;
	}
	
	@PutMapping(path="/property", consumes = {"application/json"})
	public Property saveOrUpdateProperty(@RequestBody Property property)
	{
		repo.save(property);
		return property;
	}
	
	@DeleteMapping("/property/{id}")
	public String deleteProperty(@PathVariable("id") int id)
	{
		Property property = repo.getOne(id);
		
		repo.delete(property);
		
		return "Property deleted";
	}
	
	@GetMapping("/properties")
	public List<Property> getProperties()
	{
		return repo.findAll();
	}
	
	@GetMapping("/property/{id}")
	public Optional<Property> getProperty(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
}
