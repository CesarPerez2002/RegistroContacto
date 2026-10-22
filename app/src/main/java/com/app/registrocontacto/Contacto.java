package com.app.registrocontacto;

// Modelo sencillo para representar un contacto
public class Contacto {
    private String nombre;
    private String correo;
    private String telefono;
    private String tipoContacto;

    public Contacto(String nombre, String correo, String telefono, String tipoContacto) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoContacto = tipoContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }
}
