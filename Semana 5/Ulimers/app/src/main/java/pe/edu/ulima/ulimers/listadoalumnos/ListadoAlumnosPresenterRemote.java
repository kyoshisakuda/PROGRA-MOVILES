package pe.edu.ulima.ulimers.listadoalumnos;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.ulimers.beans.Alumno;
import pe.edu.ulima.ulimers.remote.AlumnosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by W3224 on 04/05/2016.
 */
public class ListadoAlumnosPresenterRemote implements ListadoAlumnosPresenter{

    ListadoAlumnosView mView;

    public ListadoAlumnosPresenterRemote(ListadoAlumnosView view){
        mView = view;
    }

    @Override
    public void obtenerAlumnos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demo7121581.mockable.io/") //REST API de prueba creado desde mockable.io con infor de 3 alumnos en formato JSON
                .addConverterFactory(GsonConverterFactory.create()) //Usando la libreria Gson se transforman los objetos JSON
                .build();

        AlumnosService service = retrofit.create(AlumnosService.class);
        service.obtenerAlummnos().enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                // Codigo luego de la respuesta de servicio (exitosa)
                List<Alumno> alumnos = response.body();
                mView.mostrarListadoAlumnos(alumnos);
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                // Codigo luego de un error
                Log.e("Ulimers Error", t.getMessage());
            }
        });
    }

    @Override
    public void aumentarPuntaje() {

    }
}
