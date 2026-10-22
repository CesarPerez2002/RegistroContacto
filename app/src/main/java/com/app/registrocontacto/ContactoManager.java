package com.app.registrocontacto;

import java.util.ArrayList;
import java.util.List;

// Administrador en memoria para guardar los contactos (Punto 5)
public class ContactoManager {
    private static List<Contacto> listaContactos = new ArrayList<>();

    public static List<Contacto> getInstancia() {
        return listaContactos;
    }

    public static void agregarContacto(Contacto contacto) {
        listaContactos.add(contacto);
    }
}
