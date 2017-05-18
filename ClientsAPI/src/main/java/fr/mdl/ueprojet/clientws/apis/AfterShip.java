package fr.mdl.ueprojet.clientws.apis;

import fr.mdl.ueprojet.domain.Informations;
import fr.mdl.ueprojet.domain.Tracking;

import javax.json.*;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakline on 12/03/2017.
 */
public class AfterShip implements Apis {
    private static final String API_URI = "https://api.aftership.com/";
    private static final String VERSION = "v4";
    private static final String RESOURCE = "trackings";
    private static final String AUTH_KEY_PARAM = "aftership-api-key";
    private static final String AUTH_KEY_VALUE = "28682703-d99a-4680-a746-8e20709d0940";

    @Override
    public Tracking getTracking(Tracking tracking) {
        JsonArray checkpoints = getJsonArray(tracking);
        checkpoints = getJsonArray(tracking);
        List<Informations> listeInformations = new ArrayList<>();

        for (JsonValue infos : checkpoints) {
            Informations information = new Informations();
            information.setMessage(((JsonObject) infos).getString("message"));
            information.setDate(((JsonObject) infos).getString("checkpoint_time"));
            if(tracking.getCarrier().equals("chronopost-france")) {
                information.setLocation("Pas d'informations sur la localisation (non renseigné)");
            }else {
                information.setLocation(((JsonObject) infos).getString("location"));
            }
            listeInformations.add(information);
        }
        tracking.setInformations(listeInformations);
        return tracking;
    }

    /**
     * Envoie une requête GET pour récupérer les données dans un JsonArray.
     * @param tracking le colis
     * @return un tableau json contenant les données sous formes d'objets
     */
    public JsonArray getJsonArray(Tracking tracking){
        Client client = ClientBuilder.newClient();
        JsonArray checkpoints = null;
        try {
            do {
                JsonObject result = client.target(API_URI)
                        .path(VERSION)
                        .path(RESOURCE)
                        .path(tracking.getCarrier())
                        .path(tracking.getTrackingNumber())
                        .request()
                        .header(AUTH_KEY_PARAM, AUTH_KEY_VALUE)
                        .header("Content-Type", "application/json")
                        .get(JsonObject.class);

                checkpoints = result.getJsonObject("data")
                        .getJsonObject("tracking")
                        .getJsonArray("checkpoints");
            }while (checkpoints.isEmpty());

        }catch (NotFoundException e){
            System.err.println("Réponse HTTP //  " + e.getMessage());
        }catch (InternalServerErrorException e) {
            System.err.println("Réponse HTTP " + e.getResponse().getStatus());
        }
        return checkpoints;
    }

    @Override
    public JsonObject postTracking(Tracking tracking) {
        JsonObject value = Json.createObjectBuilder()
                .add("tracking", Json.createObjectBuilder()
                        .add("tracking_number",tracking.getTrackingNumber())
                        .add("slug",tracking.getCarrier()))
                .build();
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URI)
                .path(VERSION)
                .path(RESOURCE)
                .request(MediaType.APPLICATION_JSON)
                .header(AUTH_KEY_PARAM, AUTH_KEY_VALUE)
                .header("Content-Type", "application/json")
                .post(Entity.json(value));
        JsonObject result = response.readEntity(JsonObject.class);
        return result;
    }

    @Override
    public JsonObject deleteTracking(Tracking tracking) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URI)
                .path(VERSION)
                .path(RESOURCE)
                .path(tracking.getCarrier())
                .path(tracking.getTrackingNumber())
                .request()
                .header(AUTH_KEY_PARAM, AUTH_KEY_VALUE)
                .header("Content-Type", "application/json")
                .delete();
        return response.readEntity(JsonObject.class);
    }
}
