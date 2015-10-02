package pe.edu.ulima.chorreando.presenter;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.File;
import java.io.IOException;

import pe.edu.ulima.chorreando.model.dao.ChorreandoService;
import pe.edu.ulima.chorreando.model.dao.Momento;
import pe.edu.ulima.chorreando.model.dto.GenericResponse;
import pe.edu.ulima.chorreando.views.TomarFotoView;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by hquintana on 27/09/15.
 */
public class TomarFotoPresenter implements ITomarFotoPresenter {
    //private static final String url = "http://chorreando.herokuapp.com";
    private static final String url = "http://192.168.0.14:8080";

    private TomarFotoView mView;

    public TomarFotoPresenter(TomarFotoView view){
        mView = view;
    }

    @Override
    public void guardarMomento(Momento momento) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChorreandoService service = retrofit.create(ChorreandoService.class);

        //File dir = Environment.getExternalStorageDirectory();

        //File imagen = new File(dir, momento.getUrlImagen());
        Log.i("URL Imagen", momento.getUrlImagen());
        //Log.i("Tam Imagen", String.valueOf(imagen.length()));

        byte[] imagen ;
        try {
            imagen = com.google.common.io.Files.toByteArray(new File(momento.getUrlImagen()));
        } catch (IOException e) {
            mView.onError("TomarFotoPresenter (4XX): " + e.getMessage());
            return ;
        }


        service.registrarMomento(
                RequestBody.create(MediaType.parse("image/jpeg"), imagen),
                RequestBody.create(MediaType.parse("text/plain"), String.valueOf(momento.getUsuario().getIdUsuario())),
                RequestBody.create(MediaType.parse("text/plain"), momento.getLugar()),
                RequestBody.create(MediaType.parse("text/plain"), momento.getFecha()),
                RequestBody.create(MediaType.parse("text/plain"), String.valueOf(momento.getLatitud())),
                RequestBody.create(MediaType.parse("text/plain"), String.valueOf(momento.getLongitud()))
        ).enqueue(new Callback<GenericResponse>() {
            @Override
            public void onResponse(Response<GenericResponse> response, Retrofit retrofit) {
                if (response.body().getMsgStatus().equals("OK")) {
                    mView.onMomentoSaved();
                } else {
                    mView.onError(response.body().getMsgError());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                mView.onError("TomarFotoPresenter (5XX): " + t.getMessage());
            }
        });
    }
}
