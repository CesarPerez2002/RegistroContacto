package com.app.registrocontacto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// Actividad para mostrar la lista de contactos registrados con RecyclerView y ciclo de vida (Punto 5 y 6)
public class ListaContactosActivity extends AppCompatActivity {

    private static final String TAG = "ListaContactosActivity";

    private RecyclerView rvContactos;
    private TextView tvListaVacia;
    private Button btnNuevoContacto;
    private ContactoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);
        Log.d(TAG, "onCreate: Pantalla de lista iniciada");

        rvContactos = findViewById(R.id.rvContactos);
        tvListaVacia = findViewById(R.id.tvListaVacia);
        btnNuevoContacto = findViewById(R.id.btnNuevoContacto);

        // Configurar RecyclerView
        rvContactos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactoAdapter(ContactoManager.getInstancia());
        rvContactos.setAdapter(adapter);

        verificarListaVacia();

        // Botón para registrar un nuevo contacto (regresa a MainActivity)
        btnNuevoContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaContactosActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    private void verificarListaVacia() {
        if (ContactoManager.getInstancia().isEmpty()) {
            tvListaVacia.setVisibility(View.VISIBLE);
            rvContactos.setVisibility(View.GONE);
        } else {
            tvListaVacia.setVisibility(View.GONE);
            rvContactos.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Pantalla de lista visible");
        adapter.notifyDataSetChanged();
        verificarListaVacia();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Pantalla de lista interactiva");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Pantalla de lista en pausa");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Pantalla de lista detenida");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Pantalla de lista destruida");
    }
}
