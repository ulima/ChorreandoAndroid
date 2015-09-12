package pe.edu.ulima.chorreando.views;

import pe.edu.ulima.chorreando.ApplicationController;

/**
 * Created by hquintana on 12/09/15.
 */
public interface LoginView {
    public void onLoginCorrecto();
    public void onLoginIncorrecto();
    public void onError(String msg);
    public ApplicationController getApplicationController();
}
