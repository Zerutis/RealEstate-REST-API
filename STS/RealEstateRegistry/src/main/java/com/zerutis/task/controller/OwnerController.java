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

import com.zerutis.task.model.Owner;
import com.zerutis.task.service.CRUDservice;
import com.zerutis.task.service.SearchService;
import com.zerutis.task.service.TaxCalculationService;

@RestController
public class OwnerController {

	@Autowired
	TaxCalculationService taxCalculationService;
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	CRUDservice crudService;

	
	@PostMapping("/owner")
	public Owner addOwner(@RequestBody Owner owner)
	{
		return crudService.addOwner(owner);
	}
	
	@PutMapping("/owner")
	public Owner saveOrUpdateOwner(@RequestBody Owner owner)
	{
		return crudService.addOwner(owner);
	}
	
	@DeleteMapping("/owner/{id}")
	public String deleteOwner(@PathVariable("id") int id)
	{
		return crudService.deleteOwner(id);
	}
	
	@GetMapping("/owners")
	public List<Owner> getOwners()
	{
		return crudService.getOwners();
	}
	
	@GetMapping("/owner/{id}")
	public Optional<Owner> getOwner(@PathVariable("id") int id)
	{
		return crudService.getOwnerById(id);
	}
	

	
	@GetMapping("/owner/{id}/totalTax")
	public double getOwnerTotalTax(@PathVariable("id") int id)
	{
		return 15;
	}
	

}
