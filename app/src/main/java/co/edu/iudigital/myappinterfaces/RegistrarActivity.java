package co.edu.iudigital.myappinterfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegistrarActivity extends AppCompatActivity {
    EditText documento, nombre, ciudad, correo, password;

    Button regUsuario, consultarUsuario, actualizarUsuario, eliminarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        regUsuario = findViewById(R.id.btnRegUsuario);
        consultarUsuario = findViewById(R.id.btnConsultarUsuario);
        actualizarUsuario = findViewById(R.id.btnActualizarUsuario);
        eliminarUsuario = findViewById(R.id.btnEliminarUsuario);

        documento = findViewById(R.id.txtDocUsuario);
        nombre = findViewById(R.id.txtNomUsuario);
        ciudad = findViewById(R.id.txtCiudad);
        correo = findViewById(R.id.txtCorreo);
        password = (EditText)findViewById(R.id.registrarTxtPassword);


        regUsuario.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String doc = documento.getText().toString();
                String nom = nombre.getText().toString();
                String ciu = ciudad.getText().toString();
                String correoelec = correo.getText().toString();
                String pass = password.getText().toString();

                if (doc.equals("")) {
                    documento.setError("Documento vacío");
                    return;
                }

                if (nom.equals("")) {
                    nombre.setError("Nombre vacío");
                    return;
                }

                if (ciu.equals("")) {
                    ciudad.setError("Ciudad vacío");
                    return;
                }

                if (correoelec.equals("")) {
                    correo.setError("Correo vacío");
                    return;
                }

                if (!correoelec.contains("@")){
                    correo.setError("Email incorrecto, sin @");
                    return;
                }

                if (pass.equals("")) {
                    password.setError("Password vacío");
                    return;
                }

                if (pass.length() < 4) {
                    password.setError("Contraseña mínimo de 4 carácteres");
                    return;
                }

                Usuario usuario = new Usuario(doc,nom,ciu,correoelec, pass);
                usuario.save();

                documento.setText("");
                nombre.setText("");
                ciudad.setText("");
                correo.setText("");
                password.setText("");

                String datosReg;
                datosReg = "Has Registrado con exíto los siguientes Datos '\n "
                        + "Documento:  "+doc+ "\n"
                        + "Nombre:  "+nom+ "\n"
                        + "Ciudad:  "+ciu+ "\n"
                        + "Correo:  "+correoelec+ "\n"
                        + "Password:  "+"********"+ "\n";
                //+ "Password:  "+password.getText().toString()+ "\n";
                Toast.makeText(getApplicationContext(), datosReg , Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), "Usuario guardado con éxito",Toast.LENGTH_LONG).show();
            }
        });

        consultarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int doc = Integer.parseInt(documento.getText().toString());
                String doc = documento.getText().toString();

                List<Usuario> lista = Usuario.find(Usuario.class,"documento="+doc,null);
                //if(lista == null){} else {}
                if(lista.size()<=0){
                    Toast.makeText(getApplicationContext(),"usuario no existe",Toast.LENGTH_LONG).show();
                }else {
                    Usuario usuario = lista.get(0);
                    documento.setText(usuario.getDocumento());
                    nombre.setText(usuario.getNombre());
                    ciudad.setText(usuario.getCiudad());
                    correo.setText(usuario.getCorreo());
                    password.setText(usuario.getPassword());
                }
            }
        });
    }

    public void Actualizar(View view){
        //int doc = Integer.parseInt(documento.getText().toString());
       String doc =  documento.getText().toString();

        List<Usuario> lista = Usuario.find(Usuario.class,"documento="+doc,null);
        if(lista.size()<=0){
            Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_LONG).show();
        }else {
            Usuario usuario = lista.get(0);
            usuario.setDocumento(documento.getText().toString());
            usuario.setNombre(nombre.getText().toString());
            usuario.setCiudad(ciudad.getText().toString());
            usuario.setCorreo(correo.getText().toString());
            usuario.setPassword(password.getText().toString());
            usuario.save();
            Toast.makeText(getApplicationContext(),"Usuario actualizado con éxito",Toast.LENGTH_LONG).show();
        }
    }

    public void Eliminar(View view){
        //int doc = Integer.parseInt(documento.getText().toString());
        String doc = documento.getText().toString();

        List<Usuario> lista = Usuario.find(Usuario.class,"documento="+doc,null);
        if(lista.size()<=0){
            Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_LONG).show();
        }else {
            Usuario usuario = lista.get(0);
            usuario.delete();
            Toast.makeText(getApplicationContext(),"Usuario eliminado",Toast.LENGTH_LONG).show();
        }
    }


    /*
        regUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doc = documento.getText().toString();
                String nom = nombre.getText().toString();
                String ciu = ciudad.getText().toString();
                String correoelec = correo.getText().toString();
                String pass = password.getText().toString();

                String datosReg;
                datosReg = "Has Registrado los siguientes Datos '\n "
                        + "Documento:  "+doc+ "\n"
                        + "Nombre:  "+nom+ "\n"
                        + "Ciudad:  "+ciu+ "\n"
                        + "Correo:  "+correoelec+ "\n"
                        + "Password:  "+"********"+ "\n";
                        //+ "Password:  "+password.getText().toString()+ "\n";
                Toast.makeText(getApplicationContext(), datosReg , Toast.LENGTH_LONG).show();
                //Intent i = new Intent(MainActivity.this, RegistrarActivity.class);
                //startActivity(i);
            }
        });
    }*/
}