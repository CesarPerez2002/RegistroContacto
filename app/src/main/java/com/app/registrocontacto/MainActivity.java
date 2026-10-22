package com.app.registrocontacto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

// Clase principal del formulario y registro del ciclo de vida (Punto 1, 2, 3 y 6)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText etNombre;
    private EditText etCorreo;
    private EditText etTelefono;
    private RadioGroup rgTipoContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Formulario principal iniciado");

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);
        rgTipoContacto = findViewById(R.id.rgTipoContacto);
        Button btnContinuar = findViewById(R.id.btnContinuar);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Botón Continuar presionado");
                validarYContinuar();
            }
        });
    }

    private void validarYContinuar() {
        String nombre = etNombre.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();

        boolean esValido = true;

        if (nombre.isEmpty()) {
            etNombre.setError("El nombre es obligatorio");
            esValido = false;
        }

        if (correo.isEmpty()) {
            etCorreo.setError("El correo es obligatorio");
            esValido = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Ingresa un correo electrónico válido");
            esValido = false;
        }

        if (telefono.isEmpty()) {
            etTelefono.setError("El teléfono es obligatorio");
            esValido = false;
        } else if (telefono.length() != 8) {
            etTelefono.setError("El teléfono debe tener exactamente 8 dígitos");
            esValido = false;
        }

        if (esValido) {
            Log.d(TAG, "validarYContinuar: Datos válidos, pasando a Confirmación");
            int idSeleccionado = rgTipoContacto.getCheckedRadioButtonId();
            RadioButton rbSeleccionado = findViewById(idSeleccionado);
            String tipoContacto = rbSeleccionado != null ? rbSeleccionado.getText().toString() : "Personal";

            Intent intent = new Intent(MainActivity.this, ConfirmacionActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("correo", correo);
            intent.putExtra("telefono", telefono);
            intent.putExtra("tipoContacto", tipoContacto);

            startActivity(intent);
        } else {
            Log.d(TAG, "validarYContinuar: Falló la validación de datos");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Formulario principal visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Formulario principal interactivo");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Formulario principal en pausa");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Formulario principal detenido");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Formulario principal destruido");
    }
}
