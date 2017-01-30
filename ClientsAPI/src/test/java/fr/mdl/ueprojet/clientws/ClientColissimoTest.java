package fr.mdl.ueprojet.clientws;

import fr.mdl.ueprojet.domain.InfosColis;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jakline on 30/01/2017.
 */
public class ClientColissimoTest {

    InfosColis infosColis;

    @Before
    public void setUp() throws Exception {
        infosColis = new InfosColis();
    }

    @Test
    public void testGetColissimo() throws Exception {
        infosColis = ClientColissimo.getColissimo("8G00619019776");
        String status = infosColis.getStatus();
        System.out.println(infosColis.getStatus() + "\n" + infosColis.getMessage());
        assertEquals(status, "LIVRE");
    }
}