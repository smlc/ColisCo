package fr.mdl.ueprojet.clientws.apis;

import fr.mdl.ueprojet.domain.Tracking;

import java.util.List;

/**
 * Created by Jakline on 12/03/2017.
 */
public interface Apis {
    public List<Tracking> getTracking(Tracking tracking);
    //public JsonObject postTracking(Tracking tracking);
    //public JsonObject deleteTracking(Tracking tracking);
}
