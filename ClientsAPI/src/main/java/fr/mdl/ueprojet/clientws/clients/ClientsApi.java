package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.clientws.apis.Apis;
import fr.mdl.ueprojet.domain.Tracking;

import java.util.List;

/**
 * Created by Jakline on 12/03/2017.
 */
public abstract class ClientsApi {
    protected String name;
    protected Apis apis;

    public List<Tracking> getTracking(String trackingNumber){
        Tracking tracking = new Tracking();
        tracking.setTrackingNumber(trackingNumber);
        tracking.setCarrier(name);
        return apis.getTracking(tracking);
    }

    public abstract boolean isFormat(String trackingNumber);
}
