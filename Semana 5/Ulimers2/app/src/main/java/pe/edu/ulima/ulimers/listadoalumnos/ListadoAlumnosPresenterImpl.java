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
 * Created by hquintana on 3/05/16.
 */
public class ListadoAlumnosPresenterImpl implements ListadoAlumnosPresenter{

    private ListadoAlumnosView mView;

    public ListadoAlumnosPresenterImpl(ListadoAlumnosView view){
        mView = view;
    }

    @Override
    public void obtenerAlumnos() {
        /*List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno(1, "Jose Valdivia", "20053223", 0 ,"http://fakeimg.pl/250x100/"));
        alumnos.add(new Alumno(2, "Hernan Quintana", "20000260", 0 ,"http://fakeimg.pl/250x100/"));


        mView.mostrarListadoAlumnos(alumnos);*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ulimers.mybluemix.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlumnosService service = retrofit.create(AlumnosService.class);
        service.obtenerAlumnos().enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                mView.mostrarListadoAlumnos(response.body());
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                Log.e("ULimers", t.getMessage());
            }
        });
    }

    @Override
    public void aumentarPuntaje() {

    }
}
