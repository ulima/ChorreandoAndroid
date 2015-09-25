package pe.edu.ulima.chorreando.presenter;

import com.google.gson.Gson;

import pe.edu.ulima.chorreando.model.dao.ChorreandoService;
import pe.edu.ulima.chorreando.model.dto.GenericResponse;
import pe.edu.ulima.chorreando.model.dto.LoginRequest;
import pe.edu.ulima.chorreando.views.LoginView;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by hquintana on 18/09/15.
 */
public class LoginRetrofitPresenter implements ILoginPresenter{
    private static final String url = "http://chorreando.herokuapp.com";

    private LoginView view;

    public LoginRetrofitPresenter(LoginView view){
        this.view = view;
    }

    @Override
    public void login(String usuario, String password) {
        LoginRequest loginRequest = new LoginRequest(usuario, password);
        final String json = new Gson().toJson(loginRequest);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChorreandoService service = retrofit.create(ChorreandoService.class );

        service.login(loginRequest).enqueue(new Callback<GenericResponse>() {
            @Override
            public void onResponse(Response<GenericResponse> response) {
                if (response.body().getMsgStatus().equals("OK")) {
                    view.onLoginCorrecto();
                } else if (response.body().getMsgStatus().equals("ERROR")) {
                    view.onLoginIncorrecto();
                } else {
                    view.onError(response.body().getMsgError());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                view.onError("LoginPresenter (5XX): " + t.getMessage());
            }
        });


//        service.login(new RequestBody() {
//            @Override
//            public MediaType contentType() {
//                return MediaType.parse("application/json");
//            }
//
//            @Override
//            public void writeTo(BufferedSink sink) throws IOException {
//                sink.write(json.getBytes());
//            }
//        }).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Response<ResponseBody> response) {
//                GenericResponse loginResponse =
//                        null;
//                try {
//                    Log.i("LoginRetrofitPresenter", response.body().string());
//                    loginResponse = new Gson().fromJson(response.body().string(), GenericResponse.class);
//
//                    if (loginResponse.getMsgStatus().equals("OK")) {
//                        view.onLoginCorrecto();
//                    } else if (loginResponse.getMsgStatus().equals("ERROR")) {
//                        view.onLoginIncorrecto();
//                    } else {
//                        view.onError(loginResponse.getMsgError());
//                    }
//
//                } catch (IOException e) {
//                    view.onError("LoginPresenter (4XX): " + e.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                view.onError("LoginPresenter (5XX): " + t.getMessage());
//            }
//        });
    }
}
