package fr.mdl.ueprojet.clientws.clients;

import fr.mdl.ueprojet.clientws.clients.ClientsApi;
import fr.mdl.ueprojet.clientws.clients.ClientChronopost;
import fr.mdl.ueprojet.clientws.clients.ClientColissimo;
import fr.mdl.ueprojet.clientws.clients.ClientTnt;

/**
 * Created by Jakline on 11/03/2017.
 */
public class ClientFactory {

    private static ClientsApi cl;

    public static ClientsApi getInstanceClient(String code){

        if(ClientColissimo.isFormat(code)){
            return new ClientColissimo(code);
        }else if(ClientTnt.isFormat(code)){
            return new ClientTnt(code);
        }else{
            ClientChronopost.isFormat(code);
            return new ClientChronopost(code);
        }
    }

}
