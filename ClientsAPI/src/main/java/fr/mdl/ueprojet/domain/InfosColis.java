package fr.mdl.ueprojet.domain;

/**
 * Created by Jakline on 30/01/2017.
 */
public class InfosColis {
    private String status;
    private String type;
    private String code;
    private String date;
    private String message;

    @Override
    public String toString() {
        return "\nstatus : " + status + "\ntype : " + type +"\nnuméro de colis : "
                + code + "\nDate : " + date + "\nmessage : " + message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
