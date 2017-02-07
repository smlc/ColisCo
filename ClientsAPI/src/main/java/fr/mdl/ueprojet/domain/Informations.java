package fr.mdl.ueprojet.domain;

/**
 * Created by Jakline on 07/02/2017.
 */
public class Informations {

    private String date;
    private String message;
    private String lieu;

    public String toString() {
        return "\ndate : " + date + "\nmessage : " + message +"\nlieu : " + lieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

}
