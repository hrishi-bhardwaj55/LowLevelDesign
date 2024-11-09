

public class Menu {

    void showMenu() {

        System.out.println("1. Register a Rider");
        System.out.println("2. Register a Driver/Cab");
        System.out.println("3. Update Cab location");
        System.out.println("4. Switch off availability");
        System.out.println("5. Book cab");
        System.out.println("6. Fetch all history of Rider");
        System.out.println("7. End Trip");
        System.out.println("8. Exit");

    }

    void showAddName() {
        System.out.println("Enter Name");
    }

    void showXCoordinate() {
        System.out.println("Enter X Coordinate");
    }

    void showYCoordinate() {
        System.out.println("Enter Y Coordinate");
    }

    void showDriverAvailability() {
        System.out.println("Enter Driver Availability : Y or N");
    }
    void showError() {
        System.out.println("Invalid Input");
    }

    void showCabId(int id) {
        System.out.println("Your cab ID is " + id);
    }

    void showEnterCabId() {
        System.out.println("Enter cab ID");
    }

    void showLocationUpdated() {
        System.out.println("Location Updated");
    }

    void showCabAvailability() {
        System.out.println("is Cab Available");
    }

    void showRiderName() {
        System.out.println("Enter Rider Name");
    }

    void showTripFinished() {
        System.out.println("Trip Finished");
    }
}
