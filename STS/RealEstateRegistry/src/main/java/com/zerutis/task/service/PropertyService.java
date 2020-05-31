package com.zerutis.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerutis.task.dao.PropertyRepo;
import com.zerutis.task.model.Property;

@Service
public class PropertyService {
	
	@Autowired
	PropertyRepo propertyRepo;
	
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
