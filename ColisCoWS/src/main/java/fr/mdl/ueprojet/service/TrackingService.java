package fr.mdl.ueprojet.service;


import fr.mdl.ueprojet.clientws.clients.ClientFactory;
import fr.mdl.ueprojet.clientws.clients.ClientsApi;
import fr.mdl.ueprojet.domain.Tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakline on 01/03/2017.
 */
public class TrackingService {

    private ClientsApi clientsApi;
    private static List<Tracking> trackingArray = new ArrayList<Tracking>();

    /**
     * Renvoie les informations d'un seul colis à partir du numero.
     * @param code du colis
     * @return les informations du colis
     */
    public Tracking getOnlyTracking(String code){
        clientsApi = ClientFactory.getInstanceClient(code);
        return clientsApi.getTrackings();
    }

    /**
     * Prend tous les numeros de colis envoyés dans une requête get.
     * @param codes tous les numeros de colis
     * @return la liste des informations concernant tous les colis
     */
    public List<Tracking> getAllTracking(List<String> codes){

        List<Tracking> trackingList = new ArrayList<Tracking>();
        for (String code : codes){
            clientsApi = ClientFactory.getInstanceClient(code);
            trackingList.add(clientsApi.getTrackings());
        }
        return trackingList;
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

    public String checkCode(String num){

        return "";
    }
}
