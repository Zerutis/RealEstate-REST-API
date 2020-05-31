package com.zerutis.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zerutis.task.model.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Integer>
{
	
}
