package com.zerutis.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity(name="Building")
@Table(name="building")
public class Building 
{
	@Id 
	@GeneratedValue
	private int id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="property_id")
	private Property property;
	
	@Column(name = "city")
	private String city;
	@Column(name = "street")
	private String street;
	@Column(name = "number")
	private int number;
	@Column(name = "size")
	private double size;
	@Column(name = "value")
	private double value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building )) return false;
        if (!(o instanceof Property)) return false;
        return id != 0 && (id == (((Building) o).getId()) || id == (((Property) o).getId()));
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public Property getProperty() {
		return property;
	}

	public void setType(Property property) {
		this.property = property;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Building [id=" + id + ", owner=" + owner + ", property=" + property + ", city=" + city + ", street=" + street
				+ ", number=" + number + ", size=" + size + ", value=" + value + "]";
	}
	
	
	
	//public double taxValue() {
	//	return type.calculateTaxValue(value);
	//}
}
