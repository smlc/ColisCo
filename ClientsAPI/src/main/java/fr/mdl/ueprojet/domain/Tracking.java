package fr.mdl.ueprojet.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jakline on 30/01/2017.
 */
@XmlRootElement()
public class Tracking {
    private String trackingNumber;
    private String carrier;
    private Informations informations;

    public Tracking() {
    }

    public Tracking(String trackingNumber, String carrier) {
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
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

    public Informations getInformations() {
        return informations;
    }
    public void setInformations(Informations informations) {
        this.informations = informations;
    }

    public String toString(){
        return "Numero de colis : " + trackingNumber
                + "\nTransporteur : " + carrier
                + "\nDate : " + informations.getDate()
                + "\nMessage : " + informations.getMessage()
                + "\nLocation : " + informations.getLocation() + "\n";
    }
}
