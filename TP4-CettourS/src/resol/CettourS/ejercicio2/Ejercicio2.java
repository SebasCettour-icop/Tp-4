package resol.CettourS.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void ejecutar() {
        {
            Scanner scanner = new Scanner(System.in);
            Agenda agenda;

            System.out.println("¿Desea crear una agenda con tamaño personalizado? (s/n)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Introduzca el tamaño máximo de la agenda:");
                int tamaño = Integer.parseInt(scanner.nextLine());
                agenda = new Agenda(tamaño);
            } else {
                agenda = new Agenda();
            }

            int opcion;
            do {
                System.out.println("\n--- MENÚ AGENDA TELEFÓNICA ---");
                System.out.println("1. Añadir contacto");
                System.out.println("2. Buscar contacto por nombre");
                System.out.println("3. Eliminar contacto");
                System.out.println("4. Listar todos los contactos");
                System.out.println("5. Ver si la agenda está llena");
                System.out.println("6. Espacio libre en la agenda");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca el nombre del contacto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Introduzca el teléfono del contacto: ");
                        String telefono = scanner.nextLine();
                        Contacto nuevoContacto = new Contacto(nombre, telefono);
                        agenda.aniadirContacto(nuevoContacto);
                        break;

                    case 2:
                        System.out.print("Introduzca el nombre a buscar: ");
                        String nombreBuscar = scanner.nextLine();
                        agenda.buscaContacto(nombreBuscar);
                        break;

                    case 3:
                        System.out.print("Introduzca el nombre del contacto a eliminar: ");
                        String nombreEliminar = scanner.nextLine();
                        System.out.print("Introduzca el teléfono del contacto a eliminar: ");
                        String telefonoEliminar = scanner.nextLine();
                        Contacto contactoEliminar = new Contacto(nombreEliminar, telefonoEliminar);
                        agenda.eliminarContacto(contactoEliminar);
                        break;

                    case 4:
                        agenda.listarContactos();
                        break;

                    case 5:
                        if (agenda.agendaLlena()) {
                            System.out.println("La agenda está llena.");
                        } else {
                            System.out.println("La agenda no está llena.");
                        }
                        break;

                    case 6:
                        System.out.println("Espacio libre en la agenda: " + agenda.espacioLibre());
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }

            } while (opcion != 0);

            scanner.close();
        }
    }
}