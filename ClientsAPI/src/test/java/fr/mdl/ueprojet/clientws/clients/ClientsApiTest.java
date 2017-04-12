package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.domain.Tracking;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jakline on 12/04/17.
 */
public class ClientsApiTest {

    private ClientsApi clientsApi;

    @Before
    public void setUp() throws Exception {
        clientsApi = new ClientsApi();
    }

    @Test
    public void testGetTrackings() throws Exception {
        Tracking tracking;
        clientsApi = ClientFactory.getInstanceClient("DJ030008833FR");
        tracking = clientsApi.getTrackings();
        System.out.println(tracking.toString());
        assertTrue(clientsApi.getClass().equals(ClientChronopost.class));

        clientsApi = ClientFactory.getInstanceClient("8L00024797016");
        tracking = clientsApi.getTrackings();
        System.out.println(tracking.toString());
        assertTrue(clientsApi.getClass().equals(ClientColissimo.class));
    }
}