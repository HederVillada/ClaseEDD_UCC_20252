package Trabajo1;

public class Vehiculo {
    private String placa;   // placa/placa identificadora
    private String marca;   // marca del vehículo (BMW, KIA, etc.)
    private int year;       // año de fabricación
    private boolean activo; // si está operativo/activo o no

    public Vehiculo(String placa, String marca, int year, boolean activo) { //constructor
        this.placa = placa;
        this.marca = marca;
        this.year = year;
        this.activo = activo;
    }

    // Muestra la información de UN vehículo (instancia)
    public void mostrarInformacion() {
        System.out.println("Placa: " + placa + " | Marca: " + marca + " | Año: " + year + " | Activo: " + activo);
    }

    // ==== Métodos que operan sobre arreglos (estilo profe) ====

    // Itera todo el arreglo y devuelve un String con la info (para que puedas hacer println(v[0].iterarVehiculos(v)))
    public String iterarVehiculos(Vehiculo[] lista) {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : lista) {
            if (v != null) {
                sb.append("Placa: ").append(v.placa)
                  .append(" | Marca: ").append(v.marca)
                  .append(" | Año: ").append(v.year)
                  .append(" | Activo: ").append(v.activo)
                  .append("\n");
            }
        }
        return sb.toString();
    }

    // Filtra por marca (case-insensitive) y devuelve un String con las coincidencias
    public String filtrarPorMarca(Vehiculo[] lista, String buscada) {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : lista) {
            if (v != null && v.marca.equalsIgnoreCase(buscada)) {
                sb.append("Placa: ").append(v.placa)
                  .append(" | Marca: ").append(v.marca)
                  .append(" | Año: ").append(v.year)
                  .append(" | Activo: ").append(v.activo)
                  .append("\n");
            }
        }
        return sb.toString();
    }

    // Ordena el arreglo por año (ascendente) usando burbuja (modifica el arreglo en sitio)
    public void ordenarPorYear(Vehiculo[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - 1 - i; j++) {
                // proteger contra null si hay posiciones vacías
                if (lista[j] == null || lista[j + 1] == null) continue;
                if (lista[j].year > lista[j + 1].year) {
                    Vehiculo tmp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = tmp;
                }
            }
        }
    }

    // Buscar por placa (secuencial). Devuelve índice o -1 si no existe
    public int buscarPorPlaca(Vehiculo[] lista, String placaBuscada) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].placa.equalsIgnoreCase(placaBuscada)) {
                return i; // Devuelve el índice donde se encontró
            }
        }
        return -1; // No se encontró
    }

    // Actualizar el estado activo del vehículo
    public void actualizarActivo(boolean nuevoEstado) {
        this.activo = nuevoEstado;
    }
}