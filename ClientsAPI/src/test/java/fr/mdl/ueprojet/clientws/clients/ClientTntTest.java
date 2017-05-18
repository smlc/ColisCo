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
        clientTnt = new ClientTnt("3120829169675900");

    }

    @Test
    public void testIsFormat() throws Exception {
        assertTrue(ClientTnt.isFormat("3120829169675900"));
        assertFalse(ClientTnt.isFormat("412082916967590"));
    }
}