package co.edu.iudigital.myappinterfaces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class StoreActivity extends AppCompatActivity {

    TextView nombreStore, emailStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        nombreStore = findViewById(R.id.txtNombreStore);
        emailStore = findViewById(R.id.txtEmailStore);

        Bundle bundle = getIntent().getExtras();

        String nombre = bundle.getString("nombre");
        nombreStore.setText(nombre);

        String email = bundle.getString("email");
        emailStore.setText(email);
    }


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
}