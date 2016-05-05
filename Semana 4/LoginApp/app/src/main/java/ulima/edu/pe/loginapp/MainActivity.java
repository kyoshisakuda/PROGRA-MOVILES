package ulima.edu.pe.loginapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ulima.edu.pe.loginapp.R;

public class MainActivity extends AppCompatActivity {

    TextView tviTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tviTexto = (TextView)findViewById(R.id.tviTexto);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        Usuario usuario = (Usuario)intent.getSerializableExtra("usuario");

        tviTexto.setText(String.format("Usuario: %s \n Password: %s", usuario.getUsername(), usuario.getPassword()));
    }

    public void btnMostrarMapa_OnClick(View v) {
        Uri location = Uri.parse("geo:0,0?q=Universidad	de	Lima");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        if(mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            Toast.makeText(this, "No existe el activity", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnEnviarCorreo_OnClick(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,	new String[]	{"hquintan@ulima.edu.pe"});	//	TO
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Titulo	del	correo");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Contenido	del	texto");

        if(emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        } else {
            Toast.makeText(this, "No existe el activity", Toast.LENGTH_SHORT).show();
        }
    }
}
