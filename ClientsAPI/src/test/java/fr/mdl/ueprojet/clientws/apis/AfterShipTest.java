package fr.mdl.ueprojet.clientws.apis;

import fr.mdl.ueprojet.domain.Tracking;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.json.JsonObject;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jakline on 12/03/2017.
 */
public class AfterShipTest {

    private static AfterShip afterShip;
    private static Tracking tracking;

    @Before
    public void setUp() throws Exception {
        afterShip = new AfterShip();
        tracking = new Tracking("3120829169675900","tnt-fr");
    }

    @Test
    public void testGetTracking() throws Exception {
        System.out.println("test GETTING...");
        List<Tracking> trackings = afterShip.getTracking(tracking);
        System.out.println(trackings.toString());
        Assert.assertTrue(!trackings.isEmpty());
    }

    @Test
    public void testPostTracking() throws Exception {
        System.out.println("test POSTING...");
        JsonObject result = afterShip.postTracking(tracking);
        System.out.println(result);
        Assert.assertEquals(result.getJsonObject("meta").getInt("code"), 201);
    }

    @AfterClass
    public static void testDeleteTracking() throws Exception {
        System.out.println("Après tout DELETING...");
        JsonObject result = afterShip.deleteTracking(tracking);
        System.out.println(result);
        Assert.assertEquals(result.getJsonObject("meta").getInt("code"), 200);
    }
}