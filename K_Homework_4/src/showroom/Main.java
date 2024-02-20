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
		
	}

}
