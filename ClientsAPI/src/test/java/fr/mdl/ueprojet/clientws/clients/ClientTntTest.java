package fr.mdl.ueprojet.clientws.clients;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jakline on 09/03/2017.
 */
public class ClientTntTest {

    private ClientTnt clientTnt;

    @Before
    public void setUp() throws Exception {
        clientTnt = new ClientTnt();

    }

    @Test
    public void testGetTracking() throws Exception {

    }

    @Test
    public void testIsFormat() throws Exception {
        Boolean resultat = clientTnt.isFormat("8G425452222");
        assertEquals(resultat, false);
        resultat = clientTnt.isFormat("8L425452222");
        assertEquals(resultat, false);
        resultat = clientTnt.isFormat("0055425452222");
        assertEquals(resultat, true);
    }
}