package resol.CettourS.ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();

        catalogo.agregar(new Prenda("Camisa", 35000, "M"));
        catalogo.agregar(new Prenda("Pantalón", 47000, "L"));
        catalogo.agregar(new Prenda("Zapatillas", 12000, "40"));
        catalogo.agregar(new Prenda("Remera", 28000, "M"));
        catalogo.agregar(new Prenda("Chomba", 18500, "L"));

        while (true) {
            catalogo.mostrar();
            System.out.print("Elegí prenda (número) o 0 para salir: ");
            int op = sc.nextInt();
            if (op == 0) break;

            Prenda p = catalogo.seleccionar(op);
            if (p == null) continue;

            double precio = p.precio;
            System.out.print("Pago: 1. Contado (-15%)  2. Cuotas: ");
            int pago = sc.nextInt();

            if (pago == 1) {
                precio *= 0.85;
            } else if (pago == 2) {
                System.out.print("Seleccioná cantidad de cuotas (1-12): ");
                int c = sc.nextInt();
                if (c < 1 || c > 12) continue;
                if (c > 6) precio *= 1.08;
                else if (c > 3) precio *= 1.05;
            }

            System.out.print("¿Tenes cupón de descuento? (s/n): ");
            if (sc.next().equalsIgnoreCase("s")) precio *= 0.90;

            System.out.println("Total a pagar: $" + String.format("%.2f", precio));
            System.out.print("¿Queres agregar algo más a tu compra? (s/n): ");
            if (!sc.next().equalsIgnoreCase("s")) break;
        }

        System.out.println("Gracias por tu compra");
        sc.close();
    }
}
