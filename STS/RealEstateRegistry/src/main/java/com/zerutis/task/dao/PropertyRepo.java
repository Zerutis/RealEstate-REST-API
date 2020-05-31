package com.zerutis.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zerutis.task.model.Property;

public interface PropertyRepo  extends JpaRepository<Property,Integer> {

}
