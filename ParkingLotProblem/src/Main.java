import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.exit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static IParkingLot parkingLot;

    public static void main(String[] args) {
        System.out.println("Enter the Parking lot capacity");
        Scanner in = new Scanner(System.in);
        parkingLot = new ParkingLot(in.nextInt());
        boolean menuOpen = true;
        parkingLot.parkVehicle(new CarDetails("KA-01-HH-1234","White"));
        parkingLot.parkVehicle(new CarDetails("KA-01-HH-9999","White"));
        parkingLot.parkVehicle(new CarDetails("KA-01-BB-0001","Black"));
        parkingLot.parkVehicle(new CarDetails("KA-01-HH-7777","Red"));
        parkingLot.parkVehicle(new CarDetails("KA-01-HH-2701","Blue"));
        parkingLot.parkVehicle(new CarDetails("KA-01-HH-3141","Black"));





        while(menuOpen) {
//            parkingLot.displayAll();

            System.out.println("Parking lot Menu");
            System.out.println("1. park");
            System.out.println("2. un-park");
            System.out.println("3. registration numbers of all cars of a particular colour");
            System.out.println("4. slot number in which a car with a given registration number is parked");
            System.out.println("5. slot numbers of all slots where a car of a particular colour is parked");
            System.out.println("6. exit the program");
            System.out.println(" ");



            switch (in.nextInt()) {
                case 1:
                    System.out.println("Enter the registration number and color");

//                    StringTokenizer tokenizer = new StringTokenizer(parkingLotName);
//                    String temp = in.next();
//                    System.out.println(temp);
                    CarDetails car = new CarDetails(in.next(), in.next());
                    int slot = parkingLot.parkVehicle(car);
                    System.out.println("Your slot number is" + slot);
                    break;

                    //input string and park the car
                case 2:
                    System.out.println("Enter the Slot number");
                    int parkingSlot = in.nextInt();
                    parkingLot.unParkVehicle(parkingSlot);
                    break;
                    //push the number back in stack
                case 3:
                    System.out.println("Enter the colour");
                    parkingLot.displayRegistrationOfColor(in.next());
                    break;
                case 4:
                    System.out.println("Enter the registration number");
                    parkingLot.findSlotFromRegistration(in.next());
                    break;
                case 5:
                    System.out.println("Enter the colour");
                    parkingLot.findSlotFromColor(in.next());
                    break;
                case 6:
                    menuOpen = false;
                    break;
            }
        }
    }
}