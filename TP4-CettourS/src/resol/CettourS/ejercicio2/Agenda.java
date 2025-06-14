package resol.CettourS.ejercicio2;

import java.util.ArrayList;

class Agenda {
    private ArrayList<Contacto> contactos;
    private int maxContactos;

    public Agenda() {
        this(10);
    }

    public Agenda(int maxContactos) {
        this.maxContactos = maxContactos;
        this.contactos = new ArrayList<>();
    }

    public void aniadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena. No se puede añadir más contactos.");
            return;
        }

        if (existeContacto(c)) {
            System.out.println("Ya existe un contacto con ese número de teléfono.");
            return;
        }

        contactos.add(c);
        System.out.println("Contacto añadido correctamente.");
    }

    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.println("--- LISTA DE CONTACTOS ---");
        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }

    public void buscaContacto(String nombre) {
        boolean encontrado = false;
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Teléfono de " + nombre + ": " + c.getTelefono());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    public void eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("No se encontró el contacto para eliminar.");
        }
    }

    public boolean agendaLlena() {
        return contactos.size() >= maxContactos;
    }

    public int espacioLibre() {
        return maxContactos - contactos.size();
    }
}