package pe.edu.ulima.chorreando.views;

import java.util.List;

import pe.edu.ulima.chorreando.model.dao.Momento;

/**
 * Created by hquintana on 26/09/15.
 */
public interface QueHaciendoView {
    public void onListaMomentosLoaded(List<Momento> momentos);
    public void onError(String error);
}
