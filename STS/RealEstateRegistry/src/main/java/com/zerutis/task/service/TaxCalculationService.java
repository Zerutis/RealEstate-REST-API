package com.zerutis.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerutis.task.dao.OwnerRepo;

@Service
public class TaxCalculationService 
{
	@Autowired
	OwnerRepo ownerRepo;
	
	public double calculateTotalTax(List<Double> value, List<Double> tax_rate) {
		int n = value.size();
		double tax = 0.0;
		for(int i = 0; i < n; i++) {
			tax += value.get(i).doubleValue() * tax_rate.get(i).doubleValue();
		}
		return tax;
	}
	
	public double getTotalTax(int Id)
	{
		List<Double> tax_rate = ownerRepo.findTaxRateById(Id);
		List<Double> value = ownerRepo.findValueById(Id);
		return calculateTotalTax(value, tax_rate);
	}
	

}
