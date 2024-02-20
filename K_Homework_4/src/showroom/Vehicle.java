package showroom;

public abstract class Vehicle {
  // protected attributes/fields
  protected String brand;
  protected String make;
  protected long modelYear;
  protected double price;
  protected VehicleColor color;
  protected FuelType fuelType;
  protected double mileage;
  protected double mass;
  protected int cylinders;
  protected double gasTankCapacity;
  protected StartMechanism startType;

  // abstract methods provided for implementation and overriding
  public abstract double calculateMaintenaceCost(double distance);
  public abstract double calculateFuleEfficiency(double distance, double fuelprice);
  public abstract void startEngine();

  // Parameterized Constructor
  public Vehicle(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
    this.brand = brand;
    this.make = make;
    this.modelYear = modelYear;
    this.price = price;
    this.color = color;
    this.fuelType = fuelType;
    this.mileage = mileage;
    this.mass = mass;
    this.cylinders = cylinders;
    this.gasTankCapacity = gasTankCapacity;
    this.startType = startType;
  }

  // Copy constructor
  public Vehicle(Vehicle vehicle) {
    this.brand = vehicle.brand;
    this.make = vehicle.make;
    this.modelYear = vehicle.modelYear;
    this.price = vehicle.price;
    this.color = vehicle.color;
    this.fuelType = vehicle.fuelType;
    this.mileage = vehicle.mileage;
    this.mass = vehicle.mass;
    this.cylinders = vehicle.cylinders;
    this.gasTankCapacity = vehicle.gasTankCapacity;
    this.startType = vehicle.startType;
  }
    
  public string toString() {
	  
  }

}
