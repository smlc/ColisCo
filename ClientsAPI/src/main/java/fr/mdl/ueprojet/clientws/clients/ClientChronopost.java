package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.clientws.apis.AfterShip;
import fr.mdl.ueprojet.domain.Tracking;

import javax.json.JsonObject;
import java.util.List;

/**
 * Created by Jakline on 11/03/2017.
 */
public class ClientChronopost extends ClientsApi {

    public ClientChronopost() {
        this.name = "chronopost-france";
        this.apis = new AfterShip();
    }
    @Override
    public boolean isFormat(String trackingNumber) {
        String twoFirstChar = trackingNumber.substring(0,2);
        if((twoFirstChar.equals("DJ")) && trackingNumber.length() == 13){
            return true;
        }else{
            return false;
        }
    }
}
