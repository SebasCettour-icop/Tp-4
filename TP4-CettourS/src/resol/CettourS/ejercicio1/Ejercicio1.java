package resol.CettourS.ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();

        catalogo.agregarPrenda(new Prenda("Camisa", 35000.0, "M"));
        catalogo.agregarPrenda(new Prenda("Pantalón", 47000.0, "L"));
        catalogo.agregarPrenda(new Prenda("Zapatillas", 12000.0, "40"));
        catalogo.agregarPrenda(new Prenda("Remera", 28000, "M"));

        while (true) {

            catalogo.mostrarCatalogo();
            System.out.print("\nSeleccione una prenda (número) o 0 para salir: ");
            int opcion = scanner.nextInt();

            if (opcion == 0) {
                System.out.println("Saliendo del módulo de Tienda de Ropa...");
                break;
            }

            Prenda prendaSeleccionada = catalogo.seleccionarPrenda(opcion);
            if (prendaSeleccionada == null) {
                System.out.println("Opción no válida. Intente de nuevo.");
                continue;
            }

            System.out.println("\nPrenda elegida: Prenda: " + prendaSeleccionada.getTipo() +
                    ", Talle: " + prendaSeleccionada.getTalle() +
                    ", Precio Base: $" + prendaSeleccionada.getPrecioBase());

            System.out.println("Métodos de pago:");
            System.out.println("1. Pago al contado (15% de descuento)");
            System.out.println("2. Pago en cuotas");
            System.out.print("Seleccione método de pago (1 o 2): ");
            int metodoPago = scanner.nextInt();

            double precioFinal = prendaSeleccionada.getPrecioBase();
            int cuotas = 0;
            boolean cuponValido = false;

            if (metodoPago == 1) {
                precioFinal *= 0.85;
                System.out.println("Descuento aplicado por pago al contado: 15%");
            } else if (metodoPago == 2) {
                System.out.print("Ingrese cantidad de cuotas (máximo 12): ");
                cuotas = scanner.nextInt();

                if (cuotas > 12 || cuotas < 1) {
                    System.out.println("Cantidad de cuotas no válida.");
                } else {
                    // Calcular recargo según cantidad de cuotas
                    double recargo = 1.0;
                    if (cuotas > 12) recargo = 1.12;
                    else if (cuotas > 6) recargo = 1.08;
                    else if (cuotas > 3) recargo = 1.05;
                    precioFinal *= recargo;
                    // Mostrar recargo redondeado a 0 decimales
                    System.out.println("Recargo aplicado por " + cuotas + " cuotas: " + String.format("%.0f", (recargo - 1) * 100) + "%");
                }
            } else {
                System.out.println("Método de pago no válido. Usando precio base.");
            }

            System.out.print("¿Desea usar un cupón válido? (s/n): ");
            String usarCupon = scanner.next().toLowerCase();
            if (usarCupon.equals("s")) {
                cuponValido = true;
                precioFinal *= 0.90;
                System.out.println("Descuento aplicado por cupón: 10%");
            }

            System.out.println("\n--- Resumen de la compra ---");
            System.out.println("Prenda elegida: " + prendaSeleccionada.getTipo() + ", Talle: " + prendaSeleccionada.getTalle());
            System.out.println("Precio base: $" + prendaSeleccionada.getPrecioBase());
            System.out.println("Método de pago: " + (metodoPago == 1 ? "Contado" : "Cuotas"));
            if (metodoPago == 2) System.out.println("Cantidad de cuotas: " + cuotas);
            if (metodoPago == 1) System.out.println("Descuento por contado: 15%");
            if (metodoPago == 2 && cuotas >= 1)
                System.out.println("Recargo por cuotas: " + (cuotas > 12 ? "12%" : (cuotas > 6 ? "8%" : (cuotas > 3 ? "5%" : "0%"))));
            if (cuponValido) System.out.println("Descuento por cupón: 10%");
            System.out.println("Precio final a pagar: $" + String.format("%.2f", precioFinal));

            System.out.print("\n¿Desea realizar otra compra? (s/n): ");
            String continuar = scanner.next().toLowerCase();
            if (!continuar.equals("s")) {
                System.out.println("Gracias por su compra");
                break;
            }
        }

        scanner.close();
    }
}