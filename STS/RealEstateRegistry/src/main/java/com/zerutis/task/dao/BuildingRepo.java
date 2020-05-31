package com.zerutis.task.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zerutis.task.model.Building;

public interface BuildingRepo extends JpaRepository<Building, Integer>
{
	@Query(value = "Select b From Building b where b.value > ?1 order by b.value")
	List<Building> findByValueGreaterThanSorted(double value);
}
