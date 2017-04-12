package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.clientws.apis.AfterShip;
import fr.mdl.ueprojet.domain.Tracking;

import javax.json.JsonObject;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jakline on 11/03/2017.
 */
public class ClientChronopost extends ClientsApi {

    private static final String MATCH_CHRONOPOST = "DJ[0-9]{9}FR";

    public ClientChronopost(String code) {
        this.trackingNumber = code;
        this.apis = new AfterShip();
    }

    public static boolean isFormat(String trackingNumber) {
        Pattern p = Pattern.compile(MATCH_CHRONOPOST) ;
        Matcher m = p.matcher(trackingNumber);
        if (m.matches()){
            name = "chronopost-france";
            return true;
        }
        return false;
    }
}
