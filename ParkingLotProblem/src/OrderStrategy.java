import java.util.Scanner;

public class OrderStrategy implements IParkingLotStrategy {

    IParkingLot parkingLot;

    public OrderStrategy(IParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void parkVehicle(String regNo) {

    }

    @Override
    public void unparkVehicle(int slot) {

    }
}
