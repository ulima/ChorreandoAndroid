package pe.edu.ulima.chorreando.presenter;

import pe.edu.ulima.chorreando.model.dao.ChorreandoService;
import pe.edu.ulima.chorreando.model.dto.ObtenerMomentosResponse;
import pe.edu.ulima.chorreando.views.QueHaciendoView;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by hquintana on 26/09/15.
 */
public class QueHaciendoPresenter implements IQueHaciendoPresenter{
    private static final String url = "http://chorreando.herokuapp.com";

    private QueHaciendoView mView;

    public QueHaciendoPresenter(QueHaciendoView view){
        mView = view;
    }

    @Override
    public void listarMomentos(Long idUsuario) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChorreandoService service = retrofit.create(ChorreandoService.class);

        service.obtenerMomentos(idUsuario).enqueue(new Callback<ObtenerMomentosResponse>() {
            @Override
            public void onResponse(Response<ObtenerMomentosResponse> response, Retrofit retrofit) {
                if (response.body().getMsgStatus().equals("OK")) {
                    mView.onListaMomentosLoaded(response.body().getMomentos());
                } else{
                    mView.onError(response.body().getMsgError());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                mView.onError("QueHaciendoPresenter (5XX): " + t.getMessage());
            }
        });
    }
}
