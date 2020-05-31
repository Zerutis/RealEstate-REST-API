package com.zerutis.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zerutis.task.model.Building;

@Service
public class TaxCalculationService {
	
	public double getTotalTax(List<Building> buildings)
	{
		double totalTax = 0;
		for (Building b : buildings) {
			totalTax += b.getValue()*b.getProperty().getTaxRate();
		}
		return totalTax;
		
	}
	
}
