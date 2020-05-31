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

import com.zerutis.task.model.Property;
import com.zerutis.task.service.CRUDservice;

@RestController
public class PropertyController {

	@Autowired
	CRUDservice crudService;
	
	@PostMapping("/property")
	public Property addProperty(@RequestBody Property property)
	{
		return crudService.addProperty(property);
	}
	
	@PutMapping("/property")
	public Property saveOrUpdateProperty(@RequestBody Property property)
	{
		return crudService.addProperty(property);
	}
	
	@DeleteMapping("/property/{id}")
	public String deleteProperty(@PathVariable("id") int id)
	{	
		return crudService.deleteProperty(id);
	}
	
	@GetMapping("/properties")
	public List<Property> getProperties()
	{
		return crudService.getProperties();
	}
	
	@GetMapping("/property/{id}")
	public Optional<Property> getProperty(@PathVariable("id") int id)
	{
		return crudService.getPropertyById(id);
	}
}
