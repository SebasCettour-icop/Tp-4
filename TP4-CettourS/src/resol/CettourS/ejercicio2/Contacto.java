package resol.CettourS.ejercicio2;

import java.util.Objects;

class Contacto {
    private final String nombre;
    private final String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Contacto c)) return false;
        return telefono.equals(c.telefono);
    }

    public int hashCode() {
        return Objects.hash(telefono);
    }

    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}
