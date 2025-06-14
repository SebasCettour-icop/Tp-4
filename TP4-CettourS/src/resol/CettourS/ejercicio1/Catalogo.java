package resol.CettourS.ejercicio1;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Prenda> prendas = new ArrayList<>();

    public void agregar(Prenda p) {
        prendas.add(p);
    }

    public void mostrar() {
        System.out.println("\n--- Catálogo ---");
        for (int i = 0; i < prendas.size(); i++)
            System.out.println((i + 1) + ". " + prendas.get(i));
    }

    public Prenda seleccionar(int i) {
        return (i >= 1 && i <= prendas.size()) ? prendas.get(i - 1) : null;
    }
}
