package showroom;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;



public class VehicleManager {
	
	private final String vehicleFilePath = "./files/vehicleList.csv";

	public ArrayList<Vehicle> vehicleList;
	
	public VehicleManager() {
		this.vehicleList = new ArrayList<Vehicle>();
	}
	
	public boolean readFromFile(String fileName) {
		
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
            String make = splitLine[1];
            String model = splitLine[2];
            int modelYear = Integer.parseInt(splitLine[3]);
            String color = splitLine[4];
            String fuelType = splitLine[5];
            int mileage = Integer.parseInt(splitLine[6]);
            double mass = Double.parseDouble(splitLine[7]);
            int cylinders = Integer.parseInt(splitLine[8]);
            int gasTankCapacity = Integer.parseInt(splitLine[9]);
            String startType = splitLine[10];
            // Create a new object of the appropriate type
            if(type.equals("Car")) {
                Car car = new Car(make, model, modelYear, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                vehicleList.add(car);
            }
            else if(type.equals("Truck")) {
                Truck truck = new Truck(make, model, modelYear, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                vehicleList.add(truck);
            }
            else if(type.equals("SUV")) {
                SUV suv = new SUV(make, model, modelYear, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                vehicleList.add(suv);
            }
            else if(type.equals("MotorBike")) {
                MotorBike motorBike = new MotorBike(make, model, modelYear, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
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
	
	public void VehicleManager(String fileName)
	{
		vehicleList = new ArrayList<Vehicle>();
        readFromFile(fileName);
    
	}
	
	public void displayAllCarInformation() 
	
	public void displayAllTruckInformation()
	
	public void displayAllSUVInformation()
	
	public void displayAllMotorBikeInformation()
	
	public void displayVehicleInformation(Vehicle v)
	
	public void displayAllVehicleInformation() 
	
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
		        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(vehicleFilePath));
            writer.write("Type,Make,Model,ModelYear,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType\n");
            for (Vehicle vehicle : vehicleList) {
                writer.write(vehicle.toString());
            }	
            writer.close();
            return true;
            } catch (Exception e) {
            	return false;
            }
	}

	
	private boolean isVehicleType(Vehicle v, Class clazz)
	
	public int getNumberOfVehichlesByType(Class clazz)
	
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance)
	
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance)
	
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice)

	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice)
	
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice)
}
