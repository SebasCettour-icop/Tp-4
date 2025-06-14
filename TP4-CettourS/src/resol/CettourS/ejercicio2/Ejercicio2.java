package resol.CettourS.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void ejecutar(Scanner sc) {
        Agenda agenda;

        System.out.print("¿Crear agenda personalizada? (s/n): ");
        String respuesta = sc.nextLine();
        agenda = respuesta.equalsIgnoreCase("s")
                ? new Agenda(pedirEntero(sc, "Tamaño máximo de la agenda: "))
                : new Agenda();

        int opcion;
        do {
            mostrarMenu();
            opcion = pedirEntero(sc, "Opción: ");

            switch (opcion) {
                case 1 -> {
                    String nombre = leerTexto(sc, "Nombre del contacto: ");
                    String telefono = leerTexto(sc, "Teléfono del contacto: ");
                    agenda.aniadirContacto(new Contacto(nombre, telefono));
                }
                case 2 -> agenda.buscaContacto(leerTexto(sc, "Nombre a buscar: "));
                case 3 -> {
                    String nombre = leerTexto(sc, "Nombre del contacto a eliminar: ");
                    String telefono = leerTexto(sc, "Teléfono del contacto: ");
                    agenda.eliminarContacto(new Contacto(nombre, telefono));
                }
                case 4 -> agenda.listarContactos();
                case 5 -> System.out.println(agenda.agendaLlena()
                        ? "La agenda está llena."
                        : "Aún hay espacio disponible.");
                case 6 -> System.out.println("Espacios libres: " + agenda.espacioLibre());
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

    }

    private static void mostrarMenu() {
        System.out.println("""
                \n--- MENÚ AGENDA TELEFÓNICA ---
                1. Añadir contacto
                2. Buscar contacto por nombre
                3. Eliminar contacto
                4. Listar todos los contactos
                5. Ver si la agenda está llena
                6. Espacio libre en la agenda
                0. Salir""");
    }

    private static int pedirEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(sc.nextLine());
    }

    private static String leerTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }
}
