package fr.mdl.ueprojet.service;


import fr.mdl.ueprojet.domain.Tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakline on 01/03/2017.
 */
public class TrackingService {

    /**
     * Classe qui calcul le format des colis.
     * @see Util
     */
    private static Util util = new Util();

    /**
     * Une liste pour stockée les numeros de colis.
     * @see Tracking
     */
    private static List<Tracking> trackingArray = new ArrayList<Tracking>();

    /**
     * Renvoie les informations d'un seul colis à partir du numero.
     * @param code du colis
     * @return les informations du colis
     */
    public List<Tracking> getOnlyTracking(String code){
        return util.getOnePackage(code);
    }

    /**
     * Prend tous les numeros de colis envoyés dans une requête get.
     * @param codes tous les numeros de colis
     * @return La liste des informations concernant tous les colis
     */
    public List<List<Tracking>> getAllTracking(List<String> codes){
        return util.getAllPackages(codes);
    }

    /**
     * Ajoute les colis (numeros) envoyés dans une requête post.
     * @param trackings la liste des colis
     * @return la liste des colis enregistrés.
     */
    public List<Tracking> postTrackingsList( List<Tracking> trackings){
        for(Tracking tracking : trackings){
            trackingArray.add(tracking);
        }
        return trackings;
    }
}
