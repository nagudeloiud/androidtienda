package co.edu.iudigital.myappinterfaces;

import static java.lang.Thread.sleep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_MyAppInterfaces);
        */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.mainTxtPassword);


        Button registrar = findViewById(R.id.btnRegistrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ingresando a registrar...", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, RegistrarActivity.class);
                startActivity(i);
            }
        });
        /*
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegistrarActivity.class);
                startActivityForResult(intent, 0);
            }
        });
         */
    }


    public void iniciarSesion(View view){
        String emailIS = email.getText().toString();
        String passwordIS = password.getText().toString();

        if (emailIS.isEmpty()) {
            email.setError("Email vacío");
            return;
        }

        if (!emailIS.contains("@")){
            email.setError("Email incorrecto, sin @");
            return;
        }

        if (passwordIS.isEmpty()) {
            password.setError("password vacío");
            return;
        }
        /*
        if (emailIS.equals("") && passwordIS.equals("")) {
            email.setError("Email vacío");
            password.setError("password vacío");
        }
        */
        if (passwordIS.toString().length()<4) {
            password.setError("Longitud de password debe ser mayor o igual a 4");
        }


        List<Usuario> lista = Usuario.find(Usuario.class,"correo = '"+emailIS+"'",null);
        if(lista.size()<=0){
            Toast.makeText(getApplicationContext(),"Usuario(email) y/o contraseña incorrecta",Toast.LENGTH_LONG).show();
        }else {
            Usuario usuario = lista.get(0);

            if ( emailIS.equals(usuario.getCorreo()) && passwordIS.equals(usuario.getPassword()) ){
                Toast.makeText(getApplicationContext(),"Ingresando a la aplicación...",Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, StoreActivity.class);
                i.putExtra("nombre", usuario.getNombre());
                i.putExtra("email", usuario.getCorreo());
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(),"Usuario(email) y/o contraseña incorrecta",Toast.LENGTH_LONG).show();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }


}