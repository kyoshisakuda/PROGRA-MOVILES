package pe.edu.ulima.ulimers.listadoalumnos;

import java.util.List;

import pe.edu.ulima.ulimers.beans.Alumno;

/**
 * Created by hquintana on 3/05/16.
 */
public interface ListadoAlumnosView {
    public void setPresenter(ListadoAlumnosPresenter presenter);
    public void mostrarListadoAlumnos(List<Alumno> alumnos);
}
