package pe.edu.ulima.ulimers.agregaralumno;

import android.util.Log;

import pe.edu.ulima.ulimers.beans.Alumno;
import pe.edu.ulima.ulimers.remote.AlumnosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by w3124 on 06/05/2016.
 */
public class AgregarAlumnoPresenterImpl implements AgregarAlumnoPresenter {

    private AgregarAlumnoView mView;

    public  AgregarAlumnoPresenterImpl(AgregarAlumnoView view) {
        mView = view;
    }

    @Override
    public void agregarAlumno(Alumno alumno) {
        //Comunicación Remota
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ulimers.mybluemix.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlumnosService service = retrofit.create(AlumnosService.class);
        service.agregarAlumno(alumno).enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call call, Response response) {
                mView.mostrarAlumnoRegistrado();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("ULimers", t.getMessage());
            }
        });
    }
}
