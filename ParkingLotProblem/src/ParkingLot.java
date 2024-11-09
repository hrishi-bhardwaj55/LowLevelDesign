import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class ParkingLot implements IParkingLot {

    private int capacity;
    private Stack ticketCounter = new Stack();

    private final Map<Integer,IVehicleDetails> vehicleDetailsMap= new TreeMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        populateTicketCounter();
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    private void populateTicketCounter() {
        for (int i = capacity; i > 0; i--) {
            ticketCounter.push(i);
        }
    }

    @Override
    public int parkVehicle(IVehicleDetails vehicleDetails) {
        Integer ticket;
        if(ticketCounter.size() > 0) {
            ticket = (Integer) ticketCounter.pop();
            vehicleDetails.setSlot(ticket);
        } else {
            System.out.println("parking lot is full");
            return -1;
        }
        vehicleDetailsMap.put(ticket,vehicleDetails);
        return ticket;
    }

    @Override
    public void unParkVehicle(Integer slot) {
        ticketCounter.push(slot);
        vehicleDetailsMap.remove(slot);
    }

    @Override
    public void displayRegistrationOfColor(String color) {
        for(IVehicleDetails entry : vehicleDetailsMap.values()) {
            if(entry.getColor().equals(color)) {
                System.out.println(entry.getRegistration());
            }
        }
    }

    @Override
    public void findSlotFromRegistration(String registration) {
        for(IVehicleDetails entry : vehicleDetailsMap.values()) {
            if(entry.getRegistration().equals(registration)) {
                System.out.println(entry.getSlot());
            }
        }
    }

    @Override
    public void findSlotFromColor(String color) {
        for(IVehicleDetails entry : vehicleDetailsMap.values()) {
            if(entry.getColor().equals(color)) {
                System.out.println(entry.getSlot());
            }
        }
    }

    @Override
    public void displayAll() {
        for(IVehicleDetails entry : vehicleDetailsMap.values()) {
            System.out.println("Slot number " + entry.getSlot());
            System.out.println("Reg Number " + entry.getRegistration());
            System.out.println("Color " + entry.getColor());

        }
    }
}
