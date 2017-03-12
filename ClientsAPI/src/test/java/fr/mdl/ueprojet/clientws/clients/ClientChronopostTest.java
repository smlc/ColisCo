package fr.mdl.ueprojet.clientws.clients;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jakline on 12/03/2017.
 */
public class ClientChronopostTest {

    private ClientChronopost clientChronopost;

    @Before
    public void setUp() throws Exception {
        clientChronopost = new ClientChronopost();
    }

    @Test
    public void testIsFormat() throws Exception {
        Boolean resultat = clientChronopost.isFormat("8G426452222");
        assertEquals(resultat, false);
        resultat = clientChronopost.isFormat("8L425452222");
        assertEquals(resultat, false);
        resultat = clientChronopost.isFormat("DJ030008833FR");
        assertEquals(resultat, true);
    }
}