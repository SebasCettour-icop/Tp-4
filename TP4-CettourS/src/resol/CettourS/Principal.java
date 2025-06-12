package resol.CettourS;

import resol.CettourS.ejercicio1.Ejercicio1;
import resol.CettourS.ejercicio2.Ejercicio2;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Tienda de Ropa");
            System.out.println("2. Agenda Telefónica");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
                opcion = -1; //evita bucle infinito
            }

            switch (opcion) {
                case 1:
                    Ejercicio1.ejecutar();
                    break;
                case 2:
                    Ejercicio2.ejecutar();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}