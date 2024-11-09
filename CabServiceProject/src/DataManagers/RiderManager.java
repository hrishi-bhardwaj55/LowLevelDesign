package DataManagers;

import Exceptions.RiderNotFoundException;
import Model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {

    public Map<String, Rider> riderMap= new HashMap<>();

    public void addRiderToDatabase(Rider rider) {
        riderMap.put(rider.getRiderName(),rider);
    }
    public void deleteRiderFromDatabase(String riderName) throws RiderNotFoundException {
        if(riderMap.containsKey(riderName)) {
            riderMap.remove(riderName);
        } else {
            throw new RiderNotFoundException();
        }
    }

    public Rider getRiderDetailsFromDatabase(String riderName) throws RiderNotFoundException {
        if(riderMap.containsKey(riderName)) {
            return riderMap.get(riderName);
        }
        throw new RiderNotFoundException();
    }
}
