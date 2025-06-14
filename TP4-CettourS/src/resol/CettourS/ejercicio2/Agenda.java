package resol.CettourS.ejercicio2;

import java.util.ArrayList;

class Agenda {
    private final ArrayList<Contacto> contactos;
    private final int maxContactos;

    public Agenda() {
        this(10);
    }

    public Agenda(int maxContactos) {
        this.maxContactos = maxContactos;
        this.contactos = new ArrayList<>();
    }

    public void aniadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena.");
        } else if (existeContacto(c)) {
            System.out.println("Ya existe un contacto con ese número.");
        } else {
            contactos.add(c);
            System.out.println("Contacto añadido.");
        }
    }

    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("Agenda vacía.");
        } else {
            System.out.println("--- CONTACTOS ---");
            contactos.forEach(System.out::println);
        }
    }

    public void buscaContacto(String nombre) {
        Contacto encontrado = contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        if (encontrado != null) {
            System.out.println("Teléfono de " + nombre + ": " + encontrado.getTelefono());
        } else {
            System.out.println("No se encontró el contacto.");
        }
    }

    public void eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("No se encontró el contacto.");
        }
    }

    public boolean agendaLlena() {
        return contactos.size() >= maxContactos;
    }

    public int espacioLibre() {
        return maxContactos - contactos.size();
    }
}