package fr.mdl.ueprojet.service;

import fr.mdl.ueprojet.clientws.clients.ClientsApi;
import fr.mdl.ueprojet.clientws.clients.ClientChronopost;
import fr.mdl.ueprojet.clientws.clients.ClientColissimo;
import fr.mdl.ueprojet.clientws.clients.ClientTnt;
import fr.mdl.ueprojet.domain.Tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakline on 11/03/2017.
 */
public class Util {

    private ClientsApi clientApi;

    public List<Tracking> getOnePackage(String code){
        return checkCode(code);
    }

    public List<List<Tracking>> getAllPackages(List<String> codes){
        List<List<Tracking>> packageList = new ArrayList<List<Tracking>>();
        for(String code : codes){
            packageList.add(checkCode(code));
        }
        return packageList;
    }

    public List<Tracking> checkCode(String code){
        List<Tracking> tracking = new ArrayList<Tracking>();
        if((clientApi = new ClientTnt()).isFormat(code)){
            tracking = clientApi.getTracking(code);
        }else if((clientApi = new ClientColissimo()).isFormat(code)){
            tracking = clientApi.getTracking(code);
        }else if((clientApi = new ClientChronopost()).isFormat(code)){
            tracking = clientApi.getTracking(code);
        }
        return tracking;
    }
}
