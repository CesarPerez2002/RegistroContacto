package com.app.registrocontacto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Adapter sencillo para mostrar los contactos en el RecyclerView (Punto 5)
public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    private final List<Contacto> contactos;

    public ContactoAdapter(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.tvNombre.setText(contacto.getNombre());
        holder.tvCorreo.setText("Correo: " + contacto.getCorreo());
        holder.tvTelefono.setText("Teléfono: " + contacto.getTelefono());
        holder.tvTipo.setText("Tipo: " + contacto.getTipoContacto());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvCorreo, tvTelefono, tvTipo;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvItemNombre);
            tvCorreo = itemView.findViewById(R.id.tvItemCorreo);
            tvTelefono = itemView.findViewById(R.id.tvItemTelefono);
            tvTipo = itemView.findViewById(R.id.tvItemTipo);
        }
    }
}
