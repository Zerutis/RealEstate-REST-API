package com.zerutis.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zerutis.task.model.Building;

public interface BuildingRepo extends JpaRepository<Building, Integer>
{

}
