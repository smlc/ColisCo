package fr.mdl.ueprojet.clientws;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mdl.ueprojet.domain.Informations;
import fr.mdl.ueprojet.domain.InfosColis;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakline on 30/01/2017.
 */
public class ClientColissimo {

    private static final String API_URI = "https://api.laposte.fr/suivi/v1/";
    private static final String AUTH_KEY = "lPM9jd9BJ68XfXKM8PxHf9I7lITx+Bt+ENeXU9iwXO30Vjpa6zotiPpZLyFjH52l";

    private static final String NTAG_URI = "https://api.ntag.fr";
    private static final String TRANSPORTEUR = "colissimo";

    public static InfosColis getColissimo(String numColis){
        Client client = ClientBuilder.newClient();

        try {
            JsonObject result = client.target(API_URI)
                    .path(numColis)
                    .request(MediaType.APPLICATION_JSON)
                    .header("X-Okapi-Key", AUTH_KEY)
                    .get(JsonObject.class);

            System.out.println("TESTESTEST suivant : ");
            System.out.println(result);

            ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try{
                InfosColis infoColis;
                infoColis = mapper.readValue(result.toString(), InfosColis.class);
                return infoColis;
            }catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InternalServerErrorException e) {
            System.err.println("Réponse HTTP " + e.getResponse().getStatus());
        }

        return null;
    }

    public static List<Informations> getNTagSuivi(String code) {
        Client client = ClientBuilder.newClient();
        try {
            final WebTarget target = client.target(NTAG_URI).path(TRANSPORTEUR).queryParam("id", code);
            JsonArray result = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try{
                List<Informations> infos = new ArrayList<Informations>();
                for (JsonValue jv : result) {
                    Informations test = mapper.readValue(jv.toString(), Informations.class);
                    infos.add(test);
                }
                return infos;

            }catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (InternalServerErrorException e) {
            System.err.println("Réponse HTTP " + e.getResponse().getStatus());
        }
        return null;
    }
}
