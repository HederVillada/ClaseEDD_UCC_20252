package Trabajo3Examen;

/**
 * La clase 'Casillero' representa una unidad de almacenamiento que puede contener un paquete.
 * Esta clase encapsula la lógica de un solo casillero.
 */
public class Casillero {
    // Un casillero puede contener un objeto de tipo Paquete.
    // Si es 'null', el casillero está vacío.
    private Paquete paquete;

    /**
     * Constructor de la clase Casillero. Inicialmente, el casillero está vacío.
     */
    public Casillero() {
        this.paquete = null;
    }

    /**
     * Verifica si el casillero está vacío.
     * @return 'true' si el casillero no contiene un paquete, 'false' de lo contrario.
     */
    public boolean estaVacio() {
        return this.paquete == null;
    }

    /**
     * Almacena un paquete en el casillero.
     * @param nuevoPaquete El objeto Paquete que se va a almacenar.
     */
    public void registrarPaquete(Paquete nuevoPaquete) {
        this.paquete = nuevoPaquete;
    }

    /**
     * Obtiene el paquete almacenado en este casillero.
     * @return El objeto Paquete si el casillero no está vacío, 'null' de lo contrario.
     */
    public Paquete getPaquete() {
        return this.paquete;
    }
}
