package fr.mdl.ueprojet.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakline on 30/01/2017.
 */
@XmlRootElement()
public class Tracking {
    private String trackingNumber;
    private String carrier;
    private List<Informations> informations;

    public Tracking() {} // JAXB needs this

    public Tracking(String trackingNumber, String carrier) {
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
        this.informations = new ArrayList<>();
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public List<Informations> getInformations() {
        return informations;
    }

    public void setInformations(List<Informations> informations) {
        this.informations = informations;
    }

    public String toString() {
        String s = "";
        s = "Numero de colis : " + trackingNumber + "\nTransporteur : " + carrier;
        for (Informations information : informations) {
            s += "\nDate : " + information.getDate()
                    + "\nMessage : " + information.getMessage()
                    + "\nLocation : " + information.getLocation() + "\n";
        }
        return s;
    }
}
