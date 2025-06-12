package resol.CettourS.ejercicio1;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Prenda> prendas;

    public Catalogo() {
        prendas = new ArrayList<>();
    }

    public void agregarPrenda(Prenda prenda) {
        prendas.add(prenda);
    }

    public void mostrarCatalogo() {
        System.out.println("\n--- Catálogo de Ropa ---");
        for (int i = 0; i < prendas.size(); i++) {
            Prenda p = prendas.get(i);
            System.out.println((i + 1) + ". Prenda: " + p.getTipo() + ", Talle: " + p.getTalle() + ", Precio: $" + p.getPrecioBase());
        }
    }

    public Prenda seleccionarPrenda(int indice) {
        if (indice >= 1 && indice <= prendas.size()) {
            return prendas.get(indice - 1);
        }
        return null;
    }
}