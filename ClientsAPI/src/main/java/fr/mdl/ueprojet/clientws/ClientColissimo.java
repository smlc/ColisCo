package fr.mdl.ueprojet.clientws;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mdl.ueprojet.domain.InfosColis;

import javax.json.JsonObject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Jakline on 30/01/2017.
 */
public class ClientColissimo {

    private static final String API_URI = "https://api.laposte.fr/suivi/v1/";
    //private static final String CODE = "8G00619019776";
    private static final String AUTH_KEY = "lPM9jd9BJ68XfXKM8PxHf9I7lITx+Bt+ENeXU9iwXO30Vjpa6zotiPpZLyFjH52l";

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
}
