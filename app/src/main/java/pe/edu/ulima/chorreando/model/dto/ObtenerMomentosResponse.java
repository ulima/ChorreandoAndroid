package pe.edu.ulima.chorreando.model.dto;

import java.util.List;

import pe.edu.ulima.chorreando.model.dao.Momento;

/**
 * Created by hquintana on 26/09/15.
 */
public class ObtenerMomentosResponse {
    private String msgStatus;
    private String msgError;
    private List<Momento> momentos;

    public ObtenerMomentosResponse() {
    }

    public ObtenerMomentosResponse(String msgStatus, String msgError, List<Momento> momentos) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
        this.momentos = momentos;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public List<Momento> getMomentos() {
        return momentos;
    }

    public void setMomentos(List<Momento> momentos) {
        this.momentos = momentos;
    }
}
