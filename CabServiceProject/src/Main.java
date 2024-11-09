import Commands.CommandExecutor;
import DataManagers.CabManager;
import DataManagers.RiderManager;
import DataManagers.TripManager;
import Exceptions.CabNotFoundException;
import Exceptions.RiderNotFoundException;
import Exceptions.TripNotFoundException;
import Model.Cab;
import Model.Rider;
import Model.Trip;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    private static final Menu menu = new Menu();
    public static void main(String[] args) throws CabNotFoundException, RiderNotFoundException, TripNotFoundException {
        RiderManager riderManager= new RiderManager();
        CabManager cabManager= new CabManager();
        TripManager tripManager= new TripManager();

        CommandExecutor executor = new CommandExecutor(riderManager, cabManager, tripManager);

        Scanner scanner = new Scanner(System.in);

        boolean repeat = true;
        int cabId;
        String name;
        while(repeat) {
            menu.showMenu();
            switch(scanner.nextInt()) {
                case 1:
                    menu.showAddName();
                    name = scanner.next();
                    menu.showXCoordinate();
                    double x = scanner.nextDouble();
                    menu.showYCoordinate();
                    double y = scanner.nextDouble();


                    executor.addRider(new Rider(name, x, y));
                    break;

                case 2:
                    menu.showAddName();
                    String driverName = scanner.next();
                    menu.showXCoordinate();
                    double driverXCoordinate = scanner.nextDouble();
                    menu.showYCoordinate();
                    double driverYCoordinate = scanner.nextDouble();
                    menu.showDriverAvailability();
                    String availability = scanner.next();
                    boolean available;
                    if("Y".equals(availability)){
                        available = true;
                    } else if("N".equals(availability)){
                        available = false;
                    } else {
                        menu.showError();
                        break;
                    }
                    Cab cab = new Cab(driverName, driverXCoordinate, driverYCoordinate, available);
                    menu.showCabId(cabManager.addCabToDatabase(cab));
                    break;

                case 3:
                    menu.showEnterCabId();
                    cabId = scanner.nextInt();
                    menu.showXCoordinate();
                    double xCoordinate = scanner.nextDouble();
                    menu.showYCoordinate();
                    double yCoordinate = scanner.nextDouble();
                    executor.updateCabLocation(cabId,xCoordinate,yCoordinate);
                    menu.showLocationUpdated();
                    break;

                case 4:
                    menu.showEnterCabId();
                    cabId = scanner.nextInt();
                    menu.showCabAvailability();
                    String av = scanner.next();
                    boolean boolAvailability;
                    if("Y".equals(av)){
                        boolAvailability = true;
                    } else if("N".equals(av)){
                        boolAvailability = false;
                    } else {
                        menu.showError();
                        break;
                    }
                    executor.updateAvailability(cabId,boolAvailability);

                case 5:
                    menu.showRiderName();
                    String rName = scanner.next();
                    menu.showXCoordinate();
                    double xDestination = scanner.nextDouble();
                    menu.showYCoordinate();
                    double yDestination = scanner.nextDouble();

                    Rider rider = riderManager.getRiderDetailsFromDatabase(rName);
                    Cab avCab = executor.searchForAvailableCabs(rider);
                    Trip trip = new Trip(xDestination,yDestination,avCab,rider);
                    executor.addTrip(trip);
                    break;

                case 6:
                    menu.showAddName();
                    name = scanner.next();
                    List<Trip> trips = executor.searchForUserTrips(name);
                    for(Trip trip1 : trips) {
                        trip1.display();
                    }
                    break;

                case 7:
                    menu.showAddName();
                    name = scanner.next();

                    executor.getActiveTrip(name);
                    menu.showTripFinished();
                    break;

                case 8:
                    repeat = false;
                    break;
            }
        }


    }
}