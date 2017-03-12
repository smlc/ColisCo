package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.clientws.apis.AfterShip;
import fr.mdl.ueprojet.domain.Tracking;

import java.util.List;

/**
 * Created by Jakline on 01/03/2017.
 */
public class ClientTnt extends ClientsApi{

    public ClientTnt() {
        this.name = "tnt-fr";
        this.apis = new AfterShip();
    }

    @Override
    public boolean isFormat(String trackingNumber) {
        String twoFirstChar = trackingNumber.substring(0,2);
        if((twoFirstChar.equals("8G") || twoFirstChar.equals("8L"))){
            return false;
        }else{
            return true;
        }
    }
}
