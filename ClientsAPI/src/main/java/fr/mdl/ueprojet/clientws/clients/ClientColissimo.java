package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.clientws.apis.AfterShip;
import fr.mdl.ueprojet.domain.Tracking;

import javax.json.JsonObject;
import java.util.List;

/**
 * Created by Jakline on 30/01/2017.
 */
public class ClientColissimo extends ClientsApi{

    public ClientColissimo() {
        this.name = "colissimo";
        this.apis = new AfterShip();
    }

    @Override
    public boolean isFormat(String trackingNumber) {
        String twoFirstChar = trackingNumber.substring(0,2);
        if((twoFirstChar.equals("8G") || twoFirstChar.equals("8L")) && trackingNumber.length() == 13){
            return true;
        }else{
            return false;
        }
    }
}
