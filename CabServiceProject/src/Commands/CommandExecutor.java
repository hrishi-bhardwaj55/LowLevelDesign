package Commands;

import DataManagers.CabManager;
import DataManagers.RiderManager;
import DataManagers.TripManager;
import Exceptions.CabNotFoundException;
import Exceptions.TripNotFoundException;
import Model.Cab;
import Model.Rider;
import Model.Trip;

import java.util.List;

public class CommandExecutor {

    RiderManager riderManager;

    CabManager cabManager;

    TripManager tripManager;

    public CommandExecutor(RiderManager riderManager, CabManager cabManager, TripManager tripManager) {
        this.riderManager = riderManager;
        this.cabManager = cabManager;
        this.tripManager = tripManager;
    }

    public void addRider(Rider rider) {
        riderManager.addRiderToDatabase(rider);
    }

    public void updateCabLocation(int id, double x, double y) throws CabNotFoundException {
        Cab cab = cabManager.getCabDetails(id);
        cab.setxLocation(x);
        cab.setyLocation(y);
    }

    public void updateAvailability(int id, boolean isAvailable) throws CabNotFoundException {
        Cab cab = cabManager.getCabDetails(id);
        cab.setAvailable(isAvailable);
    }

    public Cab searchForAvailableCabs(Rider rider) throws CabNotFoundException {
        return cabManager.getAvailableCab(rider);
    }

    public void addTrip(Trip trip) {
        trip.setTotalDistanceTraveled(getDistance(trip.getXDestination(),trip.getYDestination(),trip.getRider().getxLocation(),trip.getRider().getyLocation()));
        tripManager.addTrip(trip.getId(),trip);
    }

    public List<Trip> searchForUserTrips (String name) {
        return tripManager.searchTrip(name);
    }

    private double getDistance(double x, double y, double x1, double y1) {
        return Math.sqrt(Math.pow((x1-x),2) + Math.pow((y1-y),2));
    }

    public void getActiveTrip(String name) throws CabNotFoundException, TripNotFoundException {
        for(Trip trip : searchForUserTrips(name)) {
            if(!trip.getCab().isAvailable()) {
                updateAvailability(trip.getCab().getId(),true);
            }
        }
        throw new TripNotFoundException();
    }
}
