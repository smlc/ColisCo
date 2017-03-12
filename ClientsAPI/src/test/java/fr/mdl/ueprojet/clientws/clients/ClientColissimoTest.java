package fr.mdl.ueprojet.clientws.clients;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jakline on 30/01/2017.
 */
public class ClientColissimoTest {

    private ClientColissimo clientColissimo;

    @Before
    public void setUp() throws Exception {
        clientColissimo = new ClientColissimo();
    }

    @Test
    public void testGetTracking() throws Exception {

    }

    @Test
    public void testIsFormat() throws Exception {
        boolean resultat = clientColissimo.isFormat("8G42545222222");
        assertEquals(resultat, true);
        resultat = clientColissimo.isFormat("8L42545222222");
        assertEquals(resultat, true);
        resultat = clientColissimo.isFormat("0055425452222");
        assertEquals(resultat, false);
        resultat = clientColissimo.isFormat("8L5425452222");
        assertEquals(resultat, false);
    }
}