package fr.mdl.ueprojet.clientws.apis;

import fr.mdl.ueprojet.domain.Informations;
import fr.mdl.ueprojet.domain.Tracking;
import org.junit.*;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jakline on 12/03/2017.
 */
public class AfterShipTest {

    private static AfterShip afterShip;
    private static Tracking tracking;

    @BeforeClass
    public static void setUp() throws Exception {
        afterShip = new AfterShip();
        tracking = new Tracking("8G00619019776","colissimo");
    }

    @Before
    public void testPostTracking() throws Exception {
        JsonObject result = afterShip.postTracking(tracking);
        assertEquals(result.getJsonObject("meta").getInt("code"), 201);
    }

    @Test
    public void testGetTracking() throws Exception {
        Tracking track = afterShip.getTracking(tracking);
        assertTrue(!track.getInformations().isEmpty());
    }

    @After
    public void testDeleteTracking() throws Exception {
        JsonObject result = afterShip.deleteTracking(tracking);
        assertEquals(result.getJsonObject("meta").getInt("code"), 200);
    }

    @AfterClass
    public static void testGetJsonArray() throws Exception {
        Tracking tracking = new Tracking();
        tracking.setTrackingNumber("DJ030008833FR");
        tracking.setCarrier("chronopost-france");
        JsonArray result = afterShip.getJsonArray(tracking);
        assertNull("Colis introuvable",result);
    }
}