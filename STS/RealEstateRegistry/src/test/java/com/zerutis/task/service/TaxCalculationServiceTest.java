package com.zerutis.task.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.zerutis.task.dao.OwnerRepo;

class TaxCalculationServiceTest {
	
	@InjectMocks
	TaxCalculationService taxCalculationService;
	
	@Mock
	OwnerRepo ownerRepo;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testCalculateTotalTaxPositive() {
		List<Double> value = new ArrayList<Double>();
		value.add(2.5);
		List<Double> tax_rate = new ArrayList<Double>();
		tax_rate.add(2.5);
		assertEquals(6.25,taxCalculationService.calculateTotalTax(value, tax_rate));
	}
	
	@Test
	void testCalculateTotalTaxNegative() {
		List<Double> value = new ArrayList<Double>();
		value.add(2.5);
		List<Double> tax_rate = new ArrayList<Double>();
		tax_rate.add(-2.5);
		assertEquals(6.25,taxCalculationService.calculateTotalTax(value, tax_rate));
	}

}
