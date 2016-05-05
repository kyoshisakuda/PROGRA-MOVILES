package ulima.edu.pe.activity;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText eteUsuario,etePassword;
    private Button btnIngresar, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eteUsuario = (EditText) findViewById(R.id.eteUsuario);
        etePassword = (EditText) findViewById(R.id.etePassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        //Metodo 1: Clase Anónima
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Metodo 2: Crear una nueva clase (Listener) que implemente View.OnClickListener
        View.OnClickListener listener = new Listener();
        btnIngresar.setOnClickListener(listener);

        //Metodo 3: Usar la misma clase Activity que implemente View.OnClickListener
        btnIngresar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    //Metodo 3
    @Override
    public void onClick(View v) {
        String usuario = eteUsuario.getText().toString();
        String password = etePassword.getText().toString();

        if (v.getId()==R.id.btnIngresar) {
            if(usuario.equals("android") && password.equals("123")){
                Toast.makeText(this, "Login Correcto", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Login Incorrecto", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId()==R.id.btnRegistrar) {
            Toast.makeText(this, "Muestra pantalla de registro", Toast.LENGTH_LONG).show();
        }
    }

    //Metodo 2
    private class Listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
