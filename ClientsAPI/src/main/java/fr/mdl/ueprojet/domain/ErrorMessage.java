package fr.mdl.ueprojet.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jakline on 12/03/2017.
 */
@XmlRootElement
public class ErrorMessage {
    private String errorMessage;
    private String errorCode;
    private String doc;

    public ErrorMessage(String errorMessage, String errorCode, String doc) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.doc = doc;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}
