package com.zerutis.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zerutis.task.model.Building;

@Service
public class SearchService {
	
	public List<Building> getSimilarBuilding(List<Building> building, String city, String street, int number, String property_type, double size)
	{
		List<Building> result = new ArrayList<>();
		
		for(Building b : building) {
			if(city.equals(b.getCity()) && street.equals(b.getStreet()) && property_type.equals(b.getProperty().getProperty_type())) {
				result.add(b);
			}
		}
		if (result.size() > 3) {
		}
		
		return result;
	}
}
