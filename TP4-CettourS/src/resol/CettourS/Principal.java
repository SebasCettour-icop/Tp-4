package resol.CettourS;

import java.util.Scanner;
import resol.CettourS.ejercicio1.Ejercicio1;
import resol.CettourS.ejercicio2.Ejercicio2;

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

            String entrada = scanner.nextLine();
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> Ejercicio1.ejecutar(scanner);
                case 2 -> Ejercicio2.ejecutar(scanner);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
