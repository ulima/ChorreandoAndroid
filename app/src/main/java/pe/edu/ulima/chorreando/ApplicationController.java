package pe.edu.ulima.chorreando;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by hquintana on 12/09/15.
 */
public class ApplicationController extends Application{
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
