package ulima.edu.pe.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ulima.edu.pe.loginapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText eteUsuario,etePassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eteUsuario = (EditText)findViewById(R.id.eteUsuario);
        etePassword = (EditText)findViewById(R.id.etePassword);

        btnLogin = (Button)findViewById(R.id.btnLogIn);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usuario = eteUsuario.getText().toString();
        String password = etePassword.getText().toString();

        /*if(){

        }*/

        Usuario u = new Usuario(usuario,password);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("usuario", u);
        startActivity(intent);
    }
}
