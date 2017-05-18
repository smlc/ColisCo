package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.clientws.apis.AfterShip;
import fr.mdl.ueprojet.domain.Tracking;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jakline on 01/03/2017.
 */
public class ClientTnt extends ClientsApi{

    private static final String MATCH_TNT = "[0-9]{16}";

    public ClientTnt(String code) {
        this.trackingNumber = code;
        this.apis = new AfterShip();
    }

    public static boolean isFormat(String trackingNumber) {
        Pattern p = Pattern.compile(MATCH_TNT) ;
        Matcher m = p.matcher(trackingNumber);
        if (m.matches()){
            name = "tnt-fr";
            return true;
        }
        return false;
    }
}
