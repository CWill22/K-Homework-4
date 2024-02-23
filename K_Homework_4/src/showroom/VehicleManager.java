package showroom;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class VehicleManager {
	
	private final static String vehicleFilePath = "./files/vehicleList.csv";

	public ArrayList<Vehicle> vehicleList;

	public VehicleManager() {
		this.vehicleList = new ArrayList<Vehicle>();
	}
	/*
	public VehicleManager() {
		this.vehicleList = new ArrayList<Vehicle>();
	}
	*/
	
	public boolean initializeStock() {
		
	try {
        Scanner fileIn = new Scanner(new FileInputStream(vehicleFilePath));
        if (fileIn.hasNext()) {
            fileIn.nextLine(); // Skip the first line, which is the header
        }
        else {
            // If the file is empty, return false
            fileIn.close();
            return false;
        }
        while(fileIn.hasNextLine())  {
            // Split the line into an array of strings
            String line=fileIn.nextLine();
            String[] splitLine = line.split(",");
            // Convert the strings to the appropriate data types
            String type = splitLine[0];
            String brand = splitLine[1];
            String model = splitLine[2];
            long modelYear = Integer.parseInt(splitLine[3]);
            double price = Double.parseDouble(splitLine[4]);
            VehicleColor color = VehicleColor.valueOf(splitLine[5]);
            FuelType fuelType = FuelType.valueOf(splitLine[6]);
            double mileage = Double.parseDouble(splitLine[7]);
            double mass = Double.parseDouble(splitLine[8]);
            int cylinders = Integer.parseInt(splitLine[9]);
            double gasTankCapacity = Double.parseDouble(splitLine[10]);
            StartMechanism startType = StartMechanism.valueOf(splitLine[11]);
            // Create a new object of the appropriate type
            if(type.equals("Car")) {
            	Car car = new Car(brand, model, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                vehicleList.add(car);
            }
            else if(type.equals("Truck")) {
            	Truck truck = new Truck(brand, model, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                vehicleList.add(truck);
            }
            else if(type.equals("SUV")) {
            	SUV suv = new SUV(brand, model, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                vehicleList.add(suv);
            }
            else if(type.equals("MotorBike")) {
            	MotorBike motorBike = new MotorBike(brand, model, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                vehicleList.add(motorBike);
            }
            
        }
        fileIn.close();
        return true;
		} catch (FileNotFoundException e) {
		System.out.println("File not found");
		return false;
		}

        
	}
	
	
	
	public void displayAllCarInformation() 
	{
		Car car1;
		
		for (Vehicle v : vehicleList) {
			try {
				//System.out.println("In Car try block");
			    car1 = (Car) v;
                displayVehicleInformation(v);
            }
            catch(Exception e) {
                
            }
		}
		
		
	}
	
	public void displayAllTruckInformation()
	{
		Truck truck1;

		for (Vehicle v : vehicleList) {
			try {
				//System.out.println("In Truck try block");
				truck1 = (Truck) v;
				displayVehicleInformation(v);
			} catch (Exception e) {

			}
		}
	}
	
	public void displayAllSUVInformation()
	{
		SUV suv1;

		for (Vehicle v : vehicleList) {
			try {
				//System.out.println("In SUV try block");
				suv1 = (SUV) v;
				displayVehicleInformation(v);
			} catch (Exception e) {

			}
		}
	}
	
	public void displayAllMotorBikeInformation()
	{
		MotorBike motorBike1;

		for (Vehicle v : vehicleList) {
			try {
				//System.out.println("In MotorBike try block");
				motorBike1 = (MotorBike) v;
				displayVehicleInformation(v);
			} catch (Exception e) {

			}
		}
	}
	
	public void displayVehicleInformation(Vehicle v)
	{
		System.out.println(v);
	}
	
	public void displayAllVehicleInformation() 
	{
		for (Vehicle v : vehicleList) {
			displayVehicleInformation(v);
		}
	}
		
	
	
	public boolean removeVehicle(Vehicle vehicle)
	{
		if (vehicle == null) {
			return false;
		}
		this.vehicleList.remove(vehicle);
		return true;
	}
	
	public boolean addVehicle(Vehicle vehicle)
	{
		if (vehicle == null) {
			return false;
		}
		this.vehicleList.add(vehicle);
		return true;
		
	}
	
	public boolean saveVehicleList() 
	{
		BufferedWriter writer = null;
		try  {
			writer = new BufferedWriter(new FileWriter(vehicleFilePath));
			writer.write("Type,Brand,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType\n");
			//ArrayList<Vehicle> vehicles = getVehicleList();
			if(vehicleList.isEmpty())
			{
				System.out.println("File is Empty");
			}
			for (Vehicle vehicle : vehicleList) {
				System.out.println("In Vehicle write loop");
				writer.write(String.format("%s,%s,%s,%d,%f,%s,%s,%f,%f,%d,%f,%s\n",vehicle.getClass().getSimpleName(), vehicle.brand, vehicle.make,vehicle.modelYear, vehicle.price, vehicle.color.toString(), vehicle.fuelType.toString()
						, vehicle.mileage, vehicle.mass, vehicle.cylinders, vehicle.gasTankCapacity, vehicle.startType.toString()));
			}
			
			writer.close();	
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		        
		  
		        
	}

	
	private boolean isVehicleType(Vehicle v, Class clazz) {
		return clazz.isInstance(v);
	}
	
	public int getNumberOfVehichlesByType(Class clazz) {
		int counter = 0;
		for (Vehicle v : vehicleList) {
			if (isVehicleType(v, clazz)) {
				counter++;
			}
		}
		return counter;
	}
	
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
			 if (vehicleList.isEmpty()) {
	            return null; // No vehicles available
	        }
			else {
				Vehicle maxMaintCostVehicle = vehicleList.get(0);
				double maxMaintCost = vehicleList.get(0).calculateMaintenaceCost(distance);
				for (Vehicle vehicle : vehicleList) {
					double maintCost = vehicle.calculateMaintenaceCost(distance);
					if (maintCost > maxMaintCost) {
						maxMaintCost = maintCost;
						maxMaintCostVehicle = vehicle;
					}
				}
				return maxMaintCostVehicle;
			}
			 
	}
		
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
			if (vehicleList.isEmpty()) {
	            return null; // No vehicles available
	        }
			else {
				Vehicle minMaintCostVehicle = vehicleList.get(0);
				double minMaintCost = vehicleList.get(0).calculateMaintenaceCost(distance);
				for (Vehicle vehicle : vehicleList) {
					double maintCost = vehicle.calculateMaintenaceCost(distance);
					if (maintCost < minMaintCost) {
						minMaintCost = maintCost;
						minMaintCostVehicle = vehicle;
					}
				}
				return minMaintCostVehicle;
			}
	}
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice)
	{
		if (vehicleList.isEmpty())
	            return null;
	        ArrayList<Vehicle> maxEfficiencyVehicles = new ArrayList<>();
	        double maxFuelEff = Double.MIN_VALUE;
	        for (Vehicle vehicle : vehicleList) {
	            double eff = vehicle.calculateFuelEfficiency(distance, fuelPrice);
	            if (eff > maxFuelEff) {
	                maxFuelEff = eff;
	                maxEfficiencyVehicles.clear();
	                maxEfficiencyVehicles.add(vehicle);
	            } else if (eff == maxFuelEff) {
	                maxEfficiencyVehicles.add(vehicle);
	            }
	        }
	        return maxEfficiencyVehicles;
	}

	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice)
	{
		if (vehicleList.isEmpty())
	            return null;
	        ArrayList<Vehicle> minEfficiencyVehicles = new ArrayList<>();
	        double minFuelEff = Double.MAX_VALUE;
	        for (Vehicle vehicle : vehicleList) {
	            double eff = vehicle.calculateFuelEfficiency(distance, fuelPrice);
	            if (eff < minFuelEff) {
	                minFuelEff = eff;
	                minEfficiencyVehicles.clear();
	                minEfficiencyVehicles.add(vehicle);
	            } else if (eff == minFuelEff) {
	                minEfficiencyVehicles.add(vehicle);
	            }
	        }
	        return minEfficiencyVehicles;
	}
	
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice)
	{
		double eff = 0;
		int count = 0;
		for (Vehicle vehicle : vehicleList){
			if (vehicle instanceof SUV){
				eff += vehicle.calculateFuelEfficiency(distance, fuelPrice);
				count++;
			}
		}
		if (count == 0){
			return -1.0; //Pops an error code if the SUV lsit is empty
		}
		return eff/count;
	}
}
