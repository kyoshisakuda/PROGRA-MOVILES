package pe.edu.ulima.ulimers.agregaralumno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.ulima.ulimers.R;
import pe.edu.ulima.ulimers.beans.Alumno;

public class AgregarAlumnoActivity extends AppCompatActivity implements AgregarAlumnoView{

    AgregarAlumnoPresenter mPresenter;
    public EditText eteNombreAlumno, eteCodigoAlumno, eteUrlFotoAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alumno);

        eteNombreAlumno = (EditText) findViewById(R.id.eteNombreAlumno);
        eteCodigoAlumno = (EditText) findViewById(R.id.eteCodigoAlumno);
        eteUrlFotoAlumno = (EditText) findViewById(R.id.eteUrlFotoAlumno);
    }

    @Override
    public void setPresenter(AgregarAlumnoPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void mostrarAlumnoRegistrado() {
        Toast.makeText(this,"Alumno registrado",Toast.LENGTH_SHORT).show();
    }

    public void guardarAlumnoClick(View view) {
        Alumno alumno = new Alumno(
                "",
                eteNombreAlumno.getText().toString().trim(),
                eteCodigoAlumno.getText().toString().trim(),
                0,
                eteUrlFotoAlumno.getText().toString().trim()
        );

        setPresenter(new AgregarAlumnoPresenterImpl(this));

        mPresenter.agregarAlumno(alumno);
    }
}
