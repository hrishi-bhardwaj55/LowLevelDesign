package DataManagers;

import Exceptions.RiderNotFoundException;
import Model.Rider;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RiderManagerTest {

    RiderManager riderManager;
    Rider r1;
    Rider r2
            ;
    @BeforeEach
    void setUp() {
        r1 = new Rider("r1",1,2);
        r2 = new Rider("r2",100,222);
        riderManager = new RiderManager();
        riderManager.addRiderToDatabase(r1);
        riderManager.addRiderToDatabase(r2);
    }

    @Test
    void addRiderToDatabase() {
        assertEquals(riderManager.riderMap.size(), 2);

    }

    @Test
    void deleteRiderFromDatabase() throws RiderNotFoundException {
        riderManager.deleteRiderFromDatabase("r1");
        assertEquals(riderManager.riderMap.size(), 1);
    }

    @Test
    void getRiderDetailsFromDatabase() throws RiderNotFoundException {
        Rider details = riderManager.getRiderDetailsFromDatabase("r2");
        assertEquals(details,r2);
    }
}