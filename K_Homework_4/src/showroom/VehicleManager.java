package showroom;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;



public class VehicleManager {
	
	private final static String vehicleFilePath = "./files/vehicleList.csv";

	public ArrayList<Vehicle> vehicleList;
	/*
	public VehicleManager() {
		this.vehicleList = new ArrayList<Vehicle>();
	}
	*/
	
	public boolean initializeStock(String fileName) {
		
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
            double mileage = Integer.parseInt(splitLine[7]);
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
				System.out.println("In Car try block");
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
				System.out.println("In Truck try block");
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
				System.out.println("In SUV try block");
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
				System.out.println("In MotorBike try block");
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
		        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(vehicleFilePath));
            writer.write("Type,Brand,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType\n");
            for (Vehicle vehicle : vehicleList) {
                writer.write(vehicle.toString());
            }	
            writer.close();
            return true;
            } catch (Exception e) {
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
	
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
			 if (vehicleList.isEmpty()) {
	            return null; // No vehicles available
	        }
			 
	}
		
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
			if (vehicleList.isEmpty()) {
	            return null; // No vehicles available
	        }
	}
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice)

	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice)
	
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
