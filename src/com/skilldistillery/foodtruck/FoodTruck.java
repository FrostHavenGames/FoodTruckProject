package com.skilldistillery.foodtruck;

public class FoodTruck {
	private static int foodTruckID = 0;
	
	private int id;
	private String name;
	private String foodType;
	
	private double rating;
	public double getRating() {
		return rating;
	}
	
	
	public FoodTruck(String name, String foodType, double rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		
		id = foodTruckID;
		foodTruckID++;
	}
	
	@Override
	public String toString() {
		return "Food Truck ID: " + id + "\nTruck Name: " + name + "\nFood: " + foodType + "\nRating: " + rating + "\n";
	}
}
