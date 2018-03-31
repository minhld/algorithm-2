package com.usu.test.ctci;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class test74_parkinglot {
	
	public static void main(String args[]) {
		
	}
	
	enum SpotSize {
		Small, 		// motorcycle
		Medium, 	// motorcycle + car 
		Large		// motorcycle + car + bus
	}
	
	EnumMap<SpotSize, Integer> spotSizes = new EnumMap<>(SpotSize.class);
	
	public class ParkingLot {
		List<Row> rowList = new ArrayList<>();
		
		public ParkingLot() {
			spotSizes.put(SpotSize.Small, 1);
			spotSizes.put(SpotSize.Medium, 2);
			spotSizes.put(SpotSize.Large, 3);
		}
		
		public Spot getAvailableSpot(Vehicle v) {
			Spot freeSpot;
			for (Row row : rowList) {
				freeSpot = row.getAvailableSpot(v);
				if (freeSpot != null) return freeSpot;
			}
			return null;
		}
		
		public void addVehicle(Vehicle v) {
			Spot freeSpot = getAvailableSpot(v);
			freeSpot.setVehicle(v);
		}
	}
	
	public class Row {
		List<Spot> spotList = new ArrayList<>();
		List<Vehicle> vehicleList = new ArrayList<>();
		
		public List<Vehicle> getParkedVehicles() {
			return vehicleList;
		}
		
		public Spot getAvailableSpot(Vehicle v) {
			for (Spot spot : spotList) {
				if (spot.isAvailable() && spot.fitVehicle(v)) return spot;
			}
			return null;
		}
		
		public void addVehicle(Vehicle v) {
			Spot freeSpot = getAvailableSpot(v);
			freeSpot.setVehicle(v);
		}
	}
	
	public class Spot {
		public int number;
		public SpotSize size;
		public Vehicle vehicle;
		
		public Spot(SpotSize s) {
			size = s;
		}
		
		public boolean fitVehicle(Vehicle v) {
			// this should be true: vehicle size <= spot size 
			return spotSizes.get(v.size) <= spotSizes.get(size); 
		}
		
		public boolean setVehicle(Vehicle v) {
			if (fitVehicle(v)) {
				vehicle = v;
				return true;
			}
			return false;
		}
		
		public void removeVehicle() {
			vehicle = null;
		}
		
		public boolean isAvailable() {
			return vehicle != null;
		}
	}
	
	public class Vehicle {
		public SpotSize size;
	}
	
	public class Motorcycle extends Vehicle {
		public Motorcycle() {
			size = SpotSize.Small;
		}
	}
	
	public class Car extends Vehicle {
		public Car() {
			size = SpotSize.Medium;
		}
	}
	
	public class Bus extends Vehicle {
		public Bus() {
			size = SpotSize.Large;
		}
	}
}
