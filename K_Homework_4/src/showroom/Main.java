package showroom;

public class Main {
	public static void main(String[] args) {
		VehicleManager vehicleManager = new VehicleManager();
		
		boolean readSuccess = vehicleManager.initializeStock();
	        if (readSuccess) {
	            System.out.println("Vehicle data read successfully from file.");
	        } else {
	            System.out.println("Failed to read vehicle data from file.");
	        }
	        System.out.println("All Vehicle Information:");
	        vehicleManager.displayAllVehicleInformation();
		//Displays everything about all vehicles

	        System.out.println("\nAll Car Information:");
	        vehicleManager.displayAllCarInformation();
		//Displays all information for Cars

	        System.out.println("\nAll Motorbike Information:");
	        vehicleManager.displayAllMotorBikeInformation(); 
		//Displays everything about the Motorbikes

		System.out.println("\nAll SUV Information:");
		vehicleManager.displayAllSUVInformation();
		//Displays all information for SUVs
		
		System.out.println("\nAll Truck Information:");
		vehicleManager.displayAllTruckInformation();
		//Displays all information for Trucks
		
		//save the vehicle list to file
		System.out.println(vehicleManager.saveVehicleList());                                             
		
		//remove the first vehicle from the list and add a new car
		vehicleManager.removeVehicle(vehicleManager.vehicleList.get(0));
		vehicleManager.addVehicle(new Car("Toyota", "Corolla", 2015, 20000, VehicleColor.BLACK, FuelType.DIESEL, 20, 1000, 4, 20, StartMechanism.PUSHSTART));
		
		//save the vehicle list to file
		System.out.println(vehicleManager.saveVehicleList());

		//Displays everything about all vehicles

		System.out.println("All Vehicle Information:");
        	vehicleManager.displayAllVehicleInformation();
		
		
	}

}
