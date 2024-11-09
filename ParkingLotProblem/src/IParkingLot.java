public interface IParkingLot {
    int getCapacity();

    void setCapacity(int capacity);


    int parkVehicle(IVehicleDetails vehicleDetails);

    void unParkVehicle(Integer slot);

    void displayRegistrationOfColor(String color);

    void findSlotFromRegistration(String registration);

    void findSlotFromColor(String color);

    void displayAll();
}
