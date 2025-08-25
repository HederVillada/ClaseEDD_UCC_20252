package Trabajo1;

public class MainVehiculos {
    public static void main(String[] args) {
        // Creamos un arreglo de 5 vehículos tal como el ejemplo del profe
        Vehiculo[] v = new Vehiculo[5];

        v[0] = new Vehiculo("WSE2324343DS", "BMW", 2000, true);
        v[1] = new Vehiculo("OP9864HYHHYW", "KIA", 2025, false);
        v[2] = new Vehiculo("234VBGT4334F", "CHEVROLET", 2005, true);
        v[3] = new Vehiculo("QAWE3ER4RT66", "PEUGEOT", 2010, false);
        v[4] = new Vehiculo("23SDER5443DF", "MERCEDES BENZ", 1970, true);

        // Mostrar TODO el arreglo como un solo String (ideal para println)
        System.out.println("=== Lista completa de vehículos (iterarVehiculos) ===");
        System.out.println(v[0].iterarVehiculos(v)); //el método devuelve String, por eso se imprime completo
        System.out.println();

        // Filtrar por marca (ejemplo: KIA)
        System.out.println("=== Filtrar por marca = KIA ===");
        String filtradoKia = v[0].filtrarPorMarca(v, "KIA"); //devuelve String con coincidencias
        if (filtradoKia.isEmpty()) {
            System.out.println("No se encontraron vehículos KIA.");
        } else {
            System.out.println(filtradoKia);
        }
        System.out.println();

        // Ordenar por año (ascendente) y mostrar el arreglo ordenado
        System.out.println("=== Ordenar por año (asc) y mostrar ===");
        v[0].ordenarPorYear(v); //modifica 'v' en sitio
        System.out.println(v[0].iterarVehiculos(v)); //mostramos el arreglo ya ordenado
        System.out.println();

        // Buscar por placa
        System.out.println("=== Buscar por placa '234VBGT4334F' ===");
        int idx = v[0].buscarPorPlaca(v, "234VBGT4334F");
        if (idx >= 0) {
            System.out.println("Encontrado en índice: " + idx);
            v[idx].mostrarInformacion(); //muestra el vehículo encontrado
        } else {
            System.out.println("Placa no encontrada.");
        }
        System.out.println();

        // Actualizar estado 'activo' de un vehículo encontrado
        System.out.println("=== Actualizar activo del vehículo en índice " + idx + " ===");
        if (idx >= 0) {
            v[idx].actualizarActivo(false); //ejemplo: marcar como no activo
            System.out.println("Después de actualizar:");
            v[idx].mostrarInformacion();
        }
    }
}
