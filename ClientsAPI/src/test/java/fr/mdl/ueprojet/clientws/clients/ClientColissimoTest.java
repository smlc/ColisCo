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
        clientColissimo = new ClientColissimo("8L00024797016");
    }

    @Test
    public void testIsFormat() throws Exception {
        assertTrue(ClientColissimo.isFormat("8L00024797016"));
        assertFalse(ClientColissimo.isFormat("8W0002479701"));
    }
}