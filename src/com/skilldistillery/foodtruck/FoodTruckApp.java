package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static FoodTruck trucks[];
	private static final int MAX_TRUCKS = 5;
	
	public static void main(String[] args) {
	
		trucks = new FoodTruck[MAX_TRUCKS];
		
		String name, foodType;
		double rating;
		int counter = 0;
		do {
			System.out.print("Enter the food truck name: ");
			name = scanner.nextLine();
			
			if (name.equals("quit")) {
				System.out.println();
				break;
			}
			
			System.out.print("What type of food does the truck sell: ");
			foodType = scanner.nextLine();
			
			System.out.print("What would you rate the food truck: ");
			rating = scanner.nextDouble();
			scanner.nextLine();
			
			trucks[counter] = new FoodTruck(name, foodType, rating);
			counter++;
			
			System.out.println();
		} while (counter < 5);
		
		String input = "";
		do {
			System.out.println("1. Show the food trucks.");
			System.out.println("2. Show the average rating of the food trucks.");
			System.out.println("3. Display the highest rated food truck");
			System.out.println("4. Exit the program");
			
			input  = scanner.nextLine();
			switch (input) {
			case "1":
				System.out.println("\nHere are all the food trucks:");
				for (int i = 0; i < trucks.length; i++) {
					if (trucks[i] != null) {
						System.out.println(trucks[i]);
					}
				}
				
				break;
				
			case "2":
				int count = 0; 
				double total = 0;
				for (int i = 0; i < trucks.length; i++) {
					if (trucks[i] != null) {
						count++;
						total += trucks[i].getRating();
					}
				}
				
				if (count > 0 && total > 0) {
					System.out.printf("\nHere is the average rating of all the food trucks: %.2f\n\n", total / count);
				}
				else {
					System.out.println("\nHere is the average rating of all the food trucks: 0\n\n");
				}
				
				break;
				
			case "3":
				FoodTruck foodTruck = null;
				for (int i = 0; i < trucks.length; i++) {
					if (trucks[i] != null) {
						if (foodTruck == null) {
							foodTruck = trucks[i];
						}
						else {
							if (foodTruck.getRating() < trucks[i].getRating()) {
								foodTruck = trucks[i];
							}
						}
					}
				}
				
				if (foodTruck != null) {
					System.out.println("\nThis is the highest rated Food Truck: ");
					System.out.println(foodTruck);
				}
				
				break;
				
			case "4":
				System.out.println("\nThanks for using the Food Truck rating app.");
				break;

			default:
				System.out.println("Invalid choice.");
				break;
			}
			
		} while (!(input.equals("4")|| input.equals("quit") || input.equals("Quit")));
		
		for (int i = 0; i < trucks.length; i++) {
			trucks[i] = null;
		}
		
		scanner.close();
	}
}
