package pe.edu.ulima.ulimers.remote;

import java.util.List;

import pe.edu.ulima.ulimers.beans.Alumno;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlumnosService {
    @GET("/alumnos")
    Call<List<Alumno>> obtenerAlumnos();

    @POST("/alumnos")
    Call<Alumno> agregarAlumno(@Body Alumno alumno);
}
