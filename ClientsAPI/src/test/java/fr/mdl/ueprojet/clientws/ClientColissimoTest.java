package fr.mdl.ueprojet.clientws;

import fr.mdl.ueprojet.domain.Informations;
import fr.mdl.ueprojet.domain.InfosColis;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jakline on 30/01/2017.
 */
public class ClientColissimoTest {

    InfosColis infosColis;
    List<Informations> infos;

    @Before
    public void setUp() throws Exception {
        infosColis = new InfosColis();
        infos = new ArrayList<Informations>();
    }

    @Test
    public void testGetColissimo() throws Exception {
        infosColis = ClientColissimo.getColissimo("8G00619019776");
        String status = infosColis.getStatus();
        System.out.println(infosColis.getStatus() + "\n" + infosColis.getMessage());
        assertEquals(status, "LIVRE");
    }

    @Test
    public void testGetNTagSuivi() throws Exception {
        infos = ClientColissimo.getNTagSuivi("8G00580360655");
        System.out.println("Affichage object ntag dans class test");
        for(Informations inf : infos) {
            System.out.println(inf.getDate() + " " + inf.getMessage());
            assertFalse(inf.getMessage().isEmpty());
        }

    }


}