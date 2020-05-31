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

import com.zerutis.task.model.Owner;
import com.zerutis.task.service.OwnerService;
import com.zerutis.task.service.SearchService;
import com.zerutis.task.service.TaxCalculationService;

@RestController
public class OwnerController {

	@Autowired
	TaxCalculationService taxCalculationService;
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	OwnerService ownerService;

	
	@PostMapping("/owner")
	public Owner addOwner(@RequestBody Owner owner)
	{
		return ownerService.addOwner(owner);
	}
	
	@PutMapping("/owner")
	public Owner saveOrUpdateOwner(@RequestBody Owner owner)
	{
		return ownerService.addOwner(owner);
	}
	
	@DeleteMapping("/owner/{id}")
	public String deleteOwner(@PathVariable("id") int id)
	{
		return ownerService.deleteOwner(id);
	}
	
	@GetMapping("/owners")
	public List<Owner> getOwners()
	{
		return ownerService.getOwners();
	}
	
	@GetMapping("/owner/{id}")
	public Optional<Owner> getOwner(@PathVariable("id") int id)
	{
		return ownerService.getOwnerById(id);
	}
	
	@GetMapping("/owner/tax")
	public double getOwnerTax(@RequestParam("id") int id) {
		return taxCalculationService.getTotalTax(id);
	}	

}
