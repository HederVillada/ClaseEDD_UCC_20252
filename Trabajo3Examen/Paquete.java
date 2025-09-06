package Trabajo3Examen;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * La clase 'Paquete' representa un objeto de tipo paquete.
 * Cada paquete tiene un destinatario y una fecha de ingreso al sistema.
 */
public class Paquete {
    private String destinatario; // Almacena el nombre de la persona a la que va el paquete.
    private Date fechaIngreso;   // Almacena la fecha y hora en que el paquete es registrado.

    /**
     * Constructor de la clase Paquete. Se llama al crear un nuevo paquete.
     * @param destinatario El nombre de la persona a la que va el paquete.
     */
    public Paquete(String destinatario) {
        this.destinatario = destinatario;
        this.fechaIngreso = new Date(); // Asigna la fecha y hora actual al momento de la creación.
    }

    /**
     * Método para obtener el nombre del destinatario.
     * @return El nombre del destinatario.
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * Método para obtener la fecha de ingreso en un formato legible.
     * @return Una cadena de texto con la fecha y hora formateada.
     */
    public String getFechaIngreso() {
        // SimpleDateFormat se usa para dar formato a la fecha (día/mes/año hora:minuto).
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formato.format(fechaIngreso);
    }
}
