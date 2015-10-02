package pe.edu.ulima.chorreando.model.dao;

import com.squareup.okhttp.RequestBody;

import pe.edu.ulima.chorreando.model.dto.GenericResponse;
import pe.edu.ulima.chorreando.model.dto.LoginRequest;
import pe.edu.ulima.chorreando.model.dto.ObtenerMomentosResponse;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;

public interface ChorreandoService {
    @POST("/login")
    Call<GenericResponse> login(@Body LoginRequest request);

    @GET("/momentos/{id}")
    Call<ObtenerMomentosResponse> obtenerMomentos(@Path("id") long idUsuario);

    @Multipart
    @POST("momentos")
    Call<GenericResponse> registrarMomento(
            @Part("foto") RequestBody photo,
            @Part("idUsuario") RequestBody idUsuario,
            @Part("lugar") RequestBody lugar,
            @Part("fecha") RequestBody fechas,
            @Part("latitud") RequestBody latitud,
            @Part("longitud") RequestBody longitud);
}
