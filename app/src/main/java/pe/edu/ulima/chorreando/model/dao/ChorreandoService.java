package pe.edu.ulima.chorreando.model.dao;

import pe.edu.ulima.chorreando.model.dto.GenericResponse;
import pe.edu.ulima.chorreando.model.dto.LoginRequest;
import pe.edu.ulima.chorreando.model.dto.ObtenerMomentosResponse;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface ChorreandoService {
    @POST("/login")
    Call<GenericResponse> login(@Body LoginRequest request);

    @GET("/momentos/{id}")
    Call<ObtenerMomentosResponse> obtenerMomentos(@Path("id") long idUsuario);
}
