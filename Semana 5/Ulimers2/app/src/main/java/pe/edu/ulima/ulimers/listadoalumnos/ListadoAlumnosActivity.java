package pe.edu.ulima.ulimers.listadoalumnos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import pe.edu.ulima.ulimers.R;
import pe.edu.ulima.ulimers.adapters.ListadoAlumnosAdapter;
import pe.edu.ulima.ulimers.beans.Alumno;

public class ListadoAlumnosActivity extends AppCompatActivity implements ListadoAlumnosView{
    ListadoAlumnosPresenter mPresenter;

    ListView lviAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_alumnos);

        lviAlumnos = (ListView) findViewById(R.id.lviAlumnos);

        setPresenter(new ListadoAlumnosPresenterImpl(this));

        mPresenter.obtenerAlumnos();
    }

    @Override
    public void setPresenter(ListadoAlumnosPresenter presenter) {
        this.mPresenter= presenter;
    }

    @Override
    public void mostrarListadoAlumnos(List<Alumno> alumnos) {
        ListadoAlumnosAdapter adapter = new ListadoAlumnosAdapter(this, alumnos);

        lviAlumnos.setAdapter(adapter);
    }
}
