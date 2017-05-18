package fr.mdl.ueprojet.clientws.apis;

import fr.mdl.ueprojet.domain.Tracking;

import javax.json.JsonObject;
import java.util.List;

/**
 * Created by Jakline on 12/03/2017.
 */
public interface Apis {
    /**
     * Récupère les informations du colis.
     * @param tracking le colis
     * @return le colis contenant toutes les informations
     */
    public Tracking getTracking(Tracking tracking);

    /**
     * Envoie une requête post pour créer un colis.
     * @param tracking le colis
     * @return un objet json contenant les informations de création
     */
    public JsonObject postTracking(Tracking tracking);

    /**
     * Envoie une requête pour supprimer un colis.
     * @param tracking le colis
     * @return un objet json contenant les informations de suppression
     */
    public JsonObject deleteTracking(Tracking tracking);
}
