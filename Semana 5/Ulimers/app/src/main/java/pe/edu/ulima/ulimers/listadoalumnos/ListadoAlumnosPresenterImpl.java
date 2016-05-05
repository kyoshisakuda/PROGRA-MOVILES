package pe.edu.ulima.ulimers.listadoalumnos;

import java.util.ArrayList;
import java.util.List;

import pe.edu.ulima.ulimers.beans.Alumno;

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
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno(1, "Jose Valdivia", "20053223", 0 ,"http://fakeimg.pl/250x100/"));
        alumnos.add(new Alumno(2, "Hernan Quintana", "20000260", 0 ,"http://fakeimg.pl/250x100/"));


        mView.mostrarListadoAlumnos(alumnos);
    }

    @Override
    public void aumentarPuntaje() {

    }
}
