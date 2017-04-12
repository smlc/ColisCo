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
        clientChronopost = new ClientChronopost("DJ030008833FR");
    }

    @Test
    public void testIsFormat() throws Exception {
        assertTrue(ClientChronopost.isFormat("DJ030008833FR"));
        assertFalse(ClientChronopost.isFormat("DJ0004"));
    }
}