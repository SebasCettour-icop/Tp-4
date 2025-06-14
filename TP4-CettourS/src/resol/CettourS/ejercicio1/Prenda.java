package resol.CettourS.ejercicio1;

public class Prenda {
    String tipo;
    double precio;
    String talle;

    public Prenda(String tipo, double precio, String talle) {
        this.tipo = tipo;
        this.precio = precio;
        this.talle = talle;
    }

    public String toString() {
        return tipo + " - Talle: " + talle + " - $" + precio;
    }
}
