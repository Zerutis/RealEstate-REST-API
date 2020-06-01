package com.zerutis.task;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zerutis.task.controller.OwnerController;
import com.zerutis.task.model.Owner;

@SpringBootTest
class TestTaxCalculationService 
{
	@Autowired
	OwnerController ownerController;
	@Test
	public void testCalculateTotalTax()
	{
		Owner owner = new Owner();
		owner.setName("Rokas");
		owner.setId(1);
		ownerController.addOwner(owner);
		when(ownerController.getOwnerTax(1)).thenReturn(0.0);
	}

}
