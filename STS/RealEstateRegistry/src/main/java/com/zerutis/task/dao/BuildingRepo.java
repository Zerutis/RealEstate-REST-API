package com.zerutis.task.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zerutis.task.model.Building;

public interface BuildingRepo extends JpaRepository<Building, Integer>
{
	@Query(value = "Select b From Building b where b.value > ?1 order by b.value")
	List<Building> findByValueGreaterThanSorted(double value);
	
	@Query(value = "with similarAddress "
	        + "as (Select TOP 3 b.* from building b, property p "
			+ "where b.property_id = p.property_id "
			+ "and city = :city "
			+ "and street = :street "
			+ "and p.property_type = :property_type "
			+ "order by value) "
			+ "select TOP 3 *, ABS(size - 32) as diff "
			+ "from similarAddress " 
			+ "order by diff, value desc", nativeQuery = true)
	List<Building> findByParam(@Param("city") String city,
							   @Param("street") String street,
							   @Param("property_type") String property_type);
}
