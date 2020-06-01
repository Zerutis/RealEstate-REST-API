package com.zerutis.task.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.zerutis.task.dao.BuildingRepo;
import com.zerutis.task.dao.OwnerRepo;
import com.zerutis.task.dao.PropertyRepo;
import com.zerutis.task.model.Building;
import com.zerutis.task.model.Owner;
import com.zerutis.task.model.Property;

class BuildingServiceTest {

	@InjectMocks
	BuildingService buildingService;
	
	
	@Mock
	BuildingRepo buildingRepo;
	
	@Mock
	OwnerRepo ownerRepo;
	
	@Mock
	PropertyRepo propertyRepo;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddBuilding() {
		Owner owner = new Owner();
		owner.setId(1);
		owner.setName("Chalatas");
		
		Property property = new Property();
		property.setId(1);
		property.setProperty_type("House");
		property.setTaxRate(0.05);
		
		
		Building building = new Building();
		building.setId(1);
		building.setCity("Kaunas");
		building.setStreet("Karo");
		building.setNumber(123);
		building.setSize(25.3);
		building.setValue(15000);
		building.setOwner(owner);
		building.setProperty(property);
		
		//when(ownerRepo.findById(1).orElse(new Owner() ).thenReturn()

		

		
	}

}
