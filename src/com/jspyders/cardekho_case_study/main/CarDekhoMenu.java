package com.jspyders.cardekho_case_study.main;

import java.util.Scanner;

import com.jspyders.cardekho_case_study.operations.Operations;

public class CarDekhoMenu {
	public static Operations operation = new Operations();
	static boolean loop = true;
	
	public static void main(String[] args) {
		
		while (loop) {
			carDekhoMenu();
		}
	}
	
	public static void carDekhoMenu() {
		System.out.println("\n========MENU========"
												+ "\n 1. Add/Remove Car Details"
												+ "\n 2. Search Car Details"
												+ "\n 3. Edit Car Details"
												+ "\n 4. Exits");
		System.out.print("\nChoose what do you :");
		
		Scanner scanner=new Scanner(System.in);
		int choose1 = scanner.nextInt();
		
			switch (choose1) {
			case 1:{
				System.out.println("\n========MENU========"
														+ "\n 1. Add Car Details"
														+ "\n 2. Remove Car Details"
														+ "\n 3. Go Back To Main Menu");
				System.out.print("\nEnter your choice: ");
				int choose2 = scanner.nextInt();
			
				switch (choose2) {
				
				case 1:
					
					operation.addCarDetails();
					break;
			
				case 2:
					
					operation.removeCarDetails();
					break;
					
				case 3:
					
					carDekhoMenu();
					break;
					
				default:
					
					System.out.println("Invalid input. try again.!! ");
					break;
					
				}
			
		}
			break;
			
		case 2:{
			System.out.println("\n========MENU========"
													+ "\n 1. Search By ID"
													+ "\n 2. Search By Name"
													+ "\n 3. Search By Brand"
													+ "\n 4. Search By Fuel Type"
													+ "\n 5. Search All Car"
													+ "\n 6. Back to Main Menu");
			System.out.print("\nChoose what do you :");
			int choose4 = scanner.nextInt();
			
				switch (choose4) {
				
				case 1:
					
					operation.searchById();
					break;
				
				case 2:
					
					operation.searchByName();
					break;

				case 3:
					
					operation.searchByBrand();
					break;
					
				case 4:
					
					operation.searchByFuelType();
					break;
					
					
				case 5:
					
					operation.allCarDetails();
					break;
					
				case 6:
					
					carDekhoMenu();
					break;
					
				default:
					
					System.out.println("Invalid input. Try again..!!");
					break;
					
				}
		}
				break;
			
		case 3:
			
			operation.editCarDetails();
			break;
			
		case 4:
			
			System.out.println("Thank You for Visiting !!!!");
			loop=false;
			scanner.close();
			break;

		default:
			
			System.out.println("Invalid input. try again.!! ");
			break;
			
		}
	}
}