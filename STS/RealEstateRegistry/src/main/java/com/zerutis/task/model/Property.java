package com.zerutis.task.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="Property")
@Table(name="property")
public class Property {

	@Column(name = "owner_id")
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "property_type")
	private String property_type;
	@Column(name  = "tax_rate")
	private double taxRate;
	
	@JsonManagedReference(value = "property")
	@OneToMany(mappedBy="property", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Building> buildings = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getProperty_type() {
		return property_type;
	}

	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", property_type=" + property_type + ", taxRate=" + taxRate + ", buildings="
				+ buildings + "]";
	}
	
	
}
