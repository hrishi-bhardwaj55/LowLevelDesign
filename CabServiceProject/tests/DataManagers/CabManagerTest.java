package DataManagers;

import Exceptions.CabNotFoundException;
import Model.Cab;
import Model.Rider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabManagerTest {

    Cab cab;
    Cab cab1;

    CabManager cabManager;

    @Before
    public void setUp() {
        cabManager = new CabManager();
        cab = new Cab("driver1",1,2,false);
        cab1 = new Cab("driver2",4,4,true);
        cabManager.addCabToDatabase(cab1);
        cabManager.addCabToDatabase(cab);
    }

    @Test
    public void testAddCab() {
        Assert.assertEquals(2, cabManager.cabMap.size());
    }

    @Test
    public void testRemoveCab() throws CabNotFoundException {
        cabManager.deleteCabFromDatabase(1);
        Assert.assertEquals(1, cabManager.cabMap.size());
    }

    @Test
    public void testGetCab() throws CabNotFoundException {
        Cab details = cabManager.getCabDetails(1);
        Assert.assertEquals(cab, details);
    }

    @Test
    public void getAvailableCabs() throws CabNotFoundException {
        Cab avCab = cabManager.getAvailableCab(new Rider("r1",1,2));
        Assert.assertEquals(cab1, avCab);
    }

}