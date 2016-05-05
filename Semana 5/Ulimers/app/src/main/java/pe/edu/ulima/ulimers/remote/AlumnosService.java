package pe.edu.ulima.ulimers.remote;


import java.util.List;

import pe.edu.ulima.ulimers.beans.Alumno;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by W3224 on 04/05/2016.
 */
public interface AlumnosService {
    @GET("/alumnos")
    Call<List<Alumno>> obtenerAlummnos();
}
