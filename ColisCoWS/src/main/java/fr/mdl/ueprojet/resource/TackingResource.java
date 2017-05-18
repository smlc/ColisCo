package fr.mdl.ueprojet.resource;

import fr.mdl.ueprojet.domain.Tracking;
import fr.mdl.ueprojet.service.TrackingService;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakline on 01/03/2017.
 */
@Path("colisco")
public class TackingResource {

    TrackingService colisService = new TrackingService();

    /**
     * Page d'accueil du web service.
     * @return un texte au format html
     */
    @GET
    @Produces("text/html")
    public String getColis(){
        return "<h1>ColisCo Ws</h1>";
    }

    /**
     * Renvoie au format json les donnees d'un seul colis.
     * @param code du colis
     * @return une liste d'informations de suivi
     */
    @GET
    @Path("tracking/{code}")
    @Produces("application/json")
    public Tracking getOneTracking(@PathParam("code") String code){
        return colisService.getOnlyTracking(code);
    }

    /**
     * Renvoie au format json les donnes de plusieurs colis.
     * @param codes la liste des numéros de colis
     * @return une liste de toutes les informations des colis
     */
    @GET
    @Path("trackings")
    @Produces("application/json")
    public List<Tracking> getTrackingList(@QueryParam("code") List<String> codes){
        return colisService.getAllTracking(codes);
    }

    /**
     * Recupere plusieurs numero de colis
     * @param trackings les numeros au format json
     * @return le suivi des colis demandés
     */
    @POST
    @Path("trackings")
    @Produces("application/json")
    @Consumes("application/json")
    public List<Tracking> postTrackingList(List<Tracking> trackings){
        return colisService.postTrackingsList(trackings);
    }
}
