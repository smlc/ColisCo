package fr.mdl.ueprojet.domain;

/**
 * Created by Jakline on 07/02/2017.
 */

public class Informations {

    private String date;
    private String message;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        date = date.substring(0,10);
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
