package com.app.registrocontacto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// Clase para la segunda pantalla (Confirmación de datos) y registro en memoria (Punto 5 y 6)
public class ConfirmacionActivity extends AppCompatActivity {

    private static final String TAG = "ConfirmacionActivity";

    private TextView tvNombre;
    private TextView tvCorreo;
    private TextView tvTelefono;
    private TextView tvTipoContacto;
    private Button btnVolver;
    private Button btnConfirmar;

    private String nombre, correo, telefono, tipoContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        Log.d(TAG, "onCreate: Pantalla de confirmación iniciada");

        tvNombre = findViewById(R.id.tvNombre);
        tvCorreo = findViewById(R.id.tvCorreo);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvTipoContacto = findViewById(R.id.tvTipoContacto);
        btnVolver = findViewById(R.id.btnVolver);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        // Recibimos los datos enviados desde MainActivity
        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        correo = intent.getStringExtra("correo");
        telefono = intent.getStringExtra("telefono");
        tipoContacto = intent.getStringExtra("tipoContacto");

        // Mostramos los datos en pantalla
        tvNombre.setText("Nombre: " + nombre);
        tvCorreo.setText("Correo: " + correo);
        tvTelefono.setText("Teléfono: " + telefono);
        tvTipoContacto.setText("Tipo: " + tipoContacto);

        // Botón Volver: regresa al formulario sin perder los datos
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Botón Volver presionado");
                finish();
            }
        });

        // Botón Confirmar: guarda el contacto en memoria y abre la lista (Punto 5)
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Botón Confirmar presionado");
                Contacto nuevoContacto = new Contacto(nombre, correo, telefono, tipoContacto);
                ContactoManager.agregarContacto(nuevoContacto);

                Toast.makeText(ConfirmacionActivity.this, "¡Contacto guardado exitosamente!", Toast.LENGTH_SHORT).show();

                // Abrir la pantalla de lista de contactos
                Intent intentLista = new Intent(ConfirmacionActivity.this, ListaContactosActivity.class);
                startActivity(intentLista);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Pantalla de confirmación visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Pantalla de confirmación interactiva");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Pantalla de confirmación en pausa");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Pantalla de confirmación detenida");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Pantalla de confirmación destruida");
    }
}
