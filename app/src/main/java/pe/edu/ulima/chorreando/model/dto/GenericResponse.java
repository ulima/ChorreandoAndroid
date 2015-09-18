package pe.edu.ulima.chorreando.model.dto;

/**
 * Created by hquintana on 12/09/15.
 */
public class GenericResponse {
    private String msgStatus;
    private String msgError;

    public GenericResponse(String msgStatus, String msgError) {

        this.msgStatus = msgStatus;
        this.msgError = msgError;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }
}
