// Contacto simple (nombre, teléfono)
public class Contacto {
    private String nombre;
    private long numero;

    // Constructor
    public Contacto(String nombre, long numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public long getNumero() {
        return numero;
    }

    // Comparación
    public boolean esIgual(Contacto otro) {
        return this.nombre.equals(otro.nombre) &&
               this.numero == otro.numero;
    }
    public boolean igualNombre(String nombre) {
        return this.nombre.equals(nombre);
    }
    public boolean igualNumero(long numero) {
        return this.numero == numero;
    }

    // Presentar con formato
    public String toString() {
        return nombre + ": " + numero;
    }
    
}
