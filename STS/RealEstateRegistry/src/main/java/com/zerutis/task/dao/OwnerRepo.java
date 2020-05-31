package com.zerutis.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zerutis.task.model.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Integer>
{

}
