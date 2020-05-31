package com.zerutis.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerutis.task.dao.OwnerRepo;

@Service
public class TaxCalculationService {
	
	@Autowired
	OwnerRepo ownerRepo;
	

	
}
