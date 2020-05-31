package com.zerutis.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zerutis.task.model.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Integer>
{

	 @Query(value = "select Round(Sum(b.value * p.tax_rate),2) from Building b, Property p"
	 		+ " where b.property_id = p.property_id"
	 		+ " and b.owner_id = :id", nativeQuery = true)
	 double findTaxById(@Param("id") int id);
}
