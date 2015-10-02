package pe.edu.ulima.chorreando.views;

import pe.edu.ulima.chorreando.ApplicationController;

/**
 * Created by hquintana on 27/09/15.
 */
public interface TomarFotoView {
    public void onMomentoSaved();
    public void onError(String msg);
    public ApplicationController getApplicationController();
}
