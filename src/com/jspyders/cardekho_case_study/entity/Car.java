package com.jspyders.cardekho_case_study.entity;

public class Car {
	private int car_id ;
	private String car_Name;
	private String car_brand;
	private String fuel_type;
	private double price;
	
	
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getCar_Name() {
		return car_Name;
	}
	public void setCar_Name(String car_Name) {
		this.car_Name = car_Name;
	}
	public String getCar_brand() {
		return car_brand;
	}
	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
