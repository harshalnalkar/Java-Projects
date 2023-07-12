package com.jspyders.cardekho_case_study.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspyders.cardekho_case_study.entity.Car;

public class Operations {
	
	static List<Car> cars = new ArrayList<Car>();
	Scanner scanner = new Scanner(System.in);
	
	
	public void addCarDetails() {
		
		System.out.println("How many cars you want to add.");
		int addNum = scanner.nextInt();
				
		for (int i = 1; i <= addNum; i++) {
			Car car = new Car();
			
				System.out.println("\nEnter the car details :");
				System.out.println("Enter Car ID :");
				car.setCar_id(scanner.nextInt());
				System.out.println("Enter Car Name :");
				car.setCar_Name(scanner.next());
				System.out.println("Enter Car Brand :");
				car.setCar_brand(scanner.next());
				System.out.println("Enter Fuel Type :");
				car.setFuel_type(scanner.next());
				System.out.println("Enter Price :");
				car.setPrice(scanner.nextDouble());
				cars.add(car);
			
				System.out.println("Add car details "+i+" successfully..***");
		}
		allCarDetails();
	}
	
	
	
	public void removeCarDetails() {
		
		allCarDetails();
		if (cars.isEmpty() == false) {
				Car car1 = null;
				System.out.println("\nEnter car id to remove :");
				int choose3 = scanner.nextInt();
			
			for (Car car : cars) {
					if (car.getCar_id() == choose3) {
						car1 = car;
				}
			}
			
			if (car1 != null) {
					cars.remove(car1);	
					System.out.println(car1.getCar_Name()+" removed..!!!");
			} 
			else {
					System.out.println("No car details added..!!!");
			}
		} 
		
	}
	
	
	
	public void allCarDetails() {
		
		if (cars.isEmpty()) {
				System.out.println("No car details found..!!!");
		} 
		else {
				System.out.println("Total car details: " +cars.size());
				System.out.println("\ncar_id \t car_Name \t car_brand \t fuel_type \t price"
					+ "\n================================================================");
			for (Car car : cars) {
					System.out.println(car.getCar_id() +" \t "+car.getCar_Name()+" \t\t "
							+car.getCar_brand()+" \t\t "+car.getFuel_type()+" \t\t "+car.getPrice());
			}
		}
	}
	
	
	
	static List<Car> cars2 = new ArrayList<Car>();
	
	
	public void searchById() {
		if (cars.isEmpty()) {
				System.out.println("No car details found..!!!");
		}
		else {
				System.out.print("\nEnter car id : ");
				int id = scanner.nextInt();
			
			for (Car car : cars) {
					if (car.getCar_id() == id) {
						cars2.add(car);
				}
			}
			dipslayCarDetails();
		}
	}
	
	
	
	public void searchByName() {
		
		if (cars.isEmpty()) {
				System.out.println("No car details found..!!!");
		} 
		else {
				System.out.print("\nEnter car name :" );
				String name = scanner.next();
			
			for (Car car : cars) {
					if (car.getCar_Name().equalsIgnoreCase(name)) {
						cars2.add(car);
					
				}
			}
			dipslayCarDetails();
		}
	}
	
	
	
	public void searchByBrand() {
		
		if (cars.isEmpty()) {
				System.out.println("No car details found..!!!");
		}
		else {
				System.out.print("\nEnter car brand : ");
				String brand = scanner.next();
			
			for (Car car : cars) {
					if (car.getCar_brand().equalsIgnoreCase(brand)) {
						cars2.add(car);
				}
			}
			dipslayCarDetails();
		}
	}
	
	
	
	public void searchByFuelType() {
		
		if (cars.isEmpty()) {
				System.out.println("No car details found..!!!");
		} 
		else {
				System.out.print("\nEnter car fuel type : ");
				String fuel = scanner.next();
			
			for (Car car : cars) {
					if (car.getFuel_type().equalsIgnoreCase(fuel)) {
							cars2.add(car);
				}
			}
			dipslayCarDetails();
		}
	}
	
	
	
	public void dipslayCarDetails() {
		
		if (cars2.isEmpty()) {
				System.out.println("No car details found..!!!");
		} 
		else {
				System.out.println("Total car details: "+cars2.size());
				System.out.println("\ncar_id \t car_Name \t car_brand \t fuel_type \t price"
					+ "\n================================================================");
			for (Car car : cars2) {
					System.out.println(car.getCar_id() +" \t "+car.getCar_Name()+" \t\t "+car.getCar_brand()
					+" \t\t "+car.getFuel_type()+" \t\t "+car.getPrice());
			}
		}
	}
	
	
	public void editCarDetails() {
		
		allCarDetails();
		if (cars.isEmpty() == false) {
				System.out.print("\nEnter car id to update : ");
				int id = scanner.nextInt();
			
			for (Car car : cars) {
					if (car.getCar_id() == id) {
						System.out.println("\nEdit car details : "+car.getCar_id());
						System.out.println("Enter Car ID :");
						car.setCar_id(scanner.nextInt());
						System.out.println("Enter Car Name :");
						car.setCar_Name(scanner.next());
						System.out.println("Enter Car Brand :");
						car.setCar_brand(scanner.next());
						System.out.println("Enter Fuel Type :");
						car.setFuel_type(scanner.next());
						System.out.println("Enter Price :");
						car.setPrice(scanner.nextDouble());
						
						System.out.println("\nCar details Updated..!!!");
						allCarDetails();
					} 
					else {
						System.out.println("Invalid input. Try again..!!");
					}
			}
		}
	}
	
}
