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

import com.zerutis.task.dao.OwnerRepo;
import com.zerutis.task.model.Owner;
import com.zerutis.task.service.TaxCalculationService;

@RestController
public class OwnerController {

	@Autowired
	OwnerRepo repo;
	
	@Autowired
	TaxCalculationService taxCS;

	
	@PostMapping(path="/owner", consumes = {"application/json"})
	public Owner addOwner(@RequestBody Owner owner)
	{
		repo.save(owner);
		return owner;
	}
	
	@PutMapping(path="/owner", consumes = {"application/json"})
	public Owner saveOrUpdateOwner(@RequestBody Owner owner)
	{
		repo.save(owner);
		return owner;
	}
	
	@DeleteMapping("/owner/{id}")
	public String deleteOwner(@PathVariable("id") int id)
	{
		Owner owner = repo.getOne(id);
		
		repo.delete(owner);
		
		return "Owner deleted";
	}
	
	@GetMapping("/owners")
	public List<Owner> getOwners()
	{
		return repo.findAll();
	}
	
	@GetMapping("/owner/{id}")
	public Optional<Owner> getOwner(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
	
	@GetMapping("/owner/{id}/totalTax")
	public double getOwnerTotalTax(@PathVariable("id") int id)
	{
		return taxCS.getTotalTax(repo.findById(id).get().getBuildings());
	}
	

}
