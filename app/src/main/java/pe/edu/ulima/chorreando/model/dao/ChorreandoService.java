package pe.edu.ulima.chorreando.model.dao;

import pe.edu.ulima.chorreando.model.dto.GenericResponse;
import pe.edu.ulima.chorreando.model.dto.LoginRequest;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

public interface ChorreandoService {
    @POST("/ChorreandoBackend/login")
    Call<GenericResponse> login(@Body LoginRequest request);
}
