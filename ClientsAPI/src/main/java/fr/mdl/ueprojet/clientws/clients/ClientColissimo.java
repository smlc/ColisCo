package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.clientws.apis.AfterShip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jakline on 30/01/2017.
 */
public class ClientColissimo extends ClientsApi{

    private static final String MATCH_COLISSIMO = "(8G|8K|8L|8N|8U|8V|8P|8H|8J|7D|9A)[0-9]{11}";

    public ClientColissimo(String code) {
        this.trackingNumber = code;
        this.apis = new AfterShip();
    }

    public static boolean isFormat(String trackingNumber) {
        Pattern p = Pattern.compile(MATCH_COLISSIMO) ;
        Matcher m = p.matcher(trackingNumber);
        if (m.matches()){
            name = "colissimo";
            return true;
        }
        return false;
    }
}
