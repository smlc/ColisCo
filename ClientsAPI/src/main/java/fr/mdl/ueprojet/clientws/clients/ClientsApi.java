package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.clientws.apis.Apis;
import fr.mdl.ueprojet.domain.Tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakline on 12/03/2017.
 */
public class ClientsApi {
    protected Apis apis;
    protected String trackingNumber;
    protected static String name;

    public Tracking getTrackings(){
        Tracking tracking = new Tracking(this.trackingNumber, name);

        apis.postTracking(tracking);
        tracking = apis.getTracking(tracking);
        apis.deleteTracking(tracking);
        return tracking;
    }
}
