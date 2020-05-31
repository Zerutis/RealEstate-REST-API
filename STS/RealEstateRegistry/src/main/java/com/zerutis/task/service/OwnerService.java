package com.zerutis.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerutis.task.dao.OwnerRepo;
import com.zerutis.task.model.Owner;

@Service
public class OwnerService {
	@Autowired
	OwnerRepo ownerRepo;
	
	public Owner addOwner(Owner owner) {
		ownerRepo.save(owner);
		return owner;
	}
	
	public String deleteOwner(int id) {
		ownerRepo.delete(ownerRepo.getOne(id));
		return "Owner Deleted";
	}
	
	public List<Owner> getOwners(){
		return ownerRepo.findAll();
	}
	
	public Optional<Owner> getOwnerById(int id) {
		return ownerRepo.findById(id);
	}
}
