package showroom;
class Truck extends Vehicle {
    public Truck(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
        super(brand, make, modelYear, price, color, fuelType, mileage, cylinders, cylinders, gasTankCapacity, startType);
    }
    public Truck(Truck Vehicle){
        super(Vehicle.brand, Vehicle.make, Vehicle.modelYear, Vehicle.price, Vehicle.color, Vehicle.fuelType, Vehicle.mileage, Vehicle.mass ,Vehicle.cylinders, Vehicle.gasTankCapacity, Vehicle.startType);
    }

    @Override
    public double calculateMaintenanceCost(double distance){
        return distance * mass * (2024 - modelYear) * cylinders * 0.0005;
    }
    
    @Override
    public double calculateFuelEfficiency(double distance, double fuelPrice){
        return cylinders * gasTankCapacity * fuelPrice / distance * 0.1;
    }

    @Override
    public void startEngine(){
        if (startType == StartMechanism.PUSHSTART){
            System.out.println("Starting the Car Engine with " + startType);
        }
        else {
            System.out.println("Car did not start");
        }
    }
    
    //Getters and Setters
    public String getBrand() {
        return brand;
    }
    public String getMake() {
        return make;
    }
    public long getModelYear() {
        return modelYear;
    }
    public double getPrice() {
        return price;
    }
    public VehicleColor getColor() {
        return color;
    }
    public FuelType getFuelType() {
        return fuelType;
    }
    public double getMileage() {
        return mileage;
    }
    public int getCylinders() {
        return cylinders;
    }
    public doulbe getMass() {
        return mass;
    }
    public double getGasTankCapacity() {
        return gasTankCapacity;
    }
    public StartMechanism getStartType() {
        return startType;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModelYear(long modelYear) {
        this.modelYear = modelYear;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setColor(VehicleColor color) {
        this.color = color;
    }
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }
    public void setMass(double mass){
        this.mass = mass;
    }
    public void setGasTankCapacity(double gasTankCapacity) {
        this.gasTankCapacity = gasTankCapacity;
    }
    public void setStartType(StartMechanism startType) {
        this.startType = startType;
    }
}
