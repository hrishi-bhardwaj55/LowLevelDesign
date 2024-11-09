package DataManagers;

import Model.Trip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripManager {

    Map<Integer, Trip> tripsMap = new HashMap<>();

    public void addTrip(int id, Trip trip) {
        tripsMap.put(id, trip);
    }

    public Trip getTrip(int id) {
        return tripsMap.get(id);
    }

    public Trip removeTrip(int id) {
        return tripsMap.remove(id);
    }

    public List<Trip> searchTrip(String name) {
        List<Trip> trips = new ArrayList<>();
        for (Trip trip : tripsMap.values()) {
            if (trip.getRider().getRiderName().equals(name)) {
                trips.add(trip);
            }
        }
        return trips;
    }
}
