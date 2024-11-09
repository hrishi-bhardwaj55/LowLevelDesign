package DataManagers;

import Exceptions.CabNotFoundException;
import Model.Cab;
import Model.Rider;

import java.util.HashMap;
import java.util.Map;

public class CabManager {

    public Map<Integer, Cab> cabMap = new HashMap<>();

    int maxId = 0;

    double maxDistance = 50;

    public int addCabToDatabase(Cab cab) {
        ++maxId;
        cab.setId(maxId);
        cabMap.put(cab.getId(),cab);
        return maxId;
    }
    public void deleteCabFromDatabase(int id) throws CabNotFoundException {
        if(cabMap.containsKey(id)) {
            cabMap.remove(id);
        } else {
            throw new CabNotFoundException();
        }
    }

    public Cab getCabDetails(int id) throws CabNotFoundException {
        if(cabMap.containsKey(id)) {
            return cabMap.get(id);
        } else {
            throw new CabNotFoundException();
        }
    }

    public Cab getAvailableCab(Rider rider) throws CabNotFoundException {
        for (Cab cab : cabMap.values()) {
            if(isWithinDistance(cab.getxLocation(),cab.getyLocation(),rider.getxLocation(), rider.getyLocation()) && cab.isAvailable()) {
                cab.setAvailable(false);
                return cab;
            }
        }
        throw new CabNotFoundException();
    }

    private boolean isWithinDistance(double x, double y, double x1, double y1) {
        return Math.sqrt(Math.pow((x1-x),2) + Math.pow((y1-y),2)) < maxDistance;
    }
}
