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
    private static final String AUTH_KEY_VALUE = "2bee0296-f6eb-4bbd-8adb-60cf1ddc4c54";
    //"eb591ab8-2044-45ec-91ec-530f730831cb"; k

    @Override
    public List<Tracking> getTracking(Tracking tracking) {
        System.out.println(tracking.getTrackingNumber() + " transporteur : " + tracking.getCarrier());
        List<Tracking> listColis = new ArrayList<>();
        Client client = ClientBuilder.newClient();
        try {

            JsonObject postResult = postTracking(tracking);

            JsonObject result = client.target(API_URI)
                    .path(VERSION)
                    .path(RESOURCE)
                    .path(tracking.getCarrier())
                    .path(tracking.getTrackingNumber())
                    .request()
                    .header(AUTH_KEY_PARAM, AUTH_KEY_VALUE)
                    .header("Content-Type", "application/json")
                    .get(JsonObject.class);
            System.out.println( "Resultat" + result + "cccc");

            JsonArray checkpoints = result.getJsonObject("data")
                    .getJsonObject("tracking")
                    .getJsonArray("checkpoints");

            for (JsonValue infos : checkpoints) {
                Informations informations = new Informations();
                informations.setMessage(((JsonObject) infos).getString("message"));
                informations.setDate(((JsonObject) infos).getString("checkpoint_time"));
                informations.setLocation(((JsonObject) infos).getString("location"));
                Tracking track = new Tracking();
                track.setInformations(informations);
                listColis.add(track);
            }

            JsonObject deleteResult = deleteTracking(tracking);

        }catch (NullPointerException e){
            System.err.println("Réponse HTTP -- " + e.getMessage());
        }catch (ClassCastException e){
            System.err.println("Réponse HTTP ** " + e.getMessage());
        }catch (NotFoundException e){
            System.err.println("Réponse HTTP //  " + e.getMessage());
        }catch (InternalServerErrorException e) {
            System.err.println("Réponse HTTP " + e.getResponse().getStatus());
        }

        return listColis;
    }

    public JsonObject postTracking(Tracking tracking) {
        System.out.println("post");
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

    public JsonObject deleteTracking(Tracking tracking) {
        System.out.println("delete");
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
