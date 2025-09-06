package Trabajo3Examen;

import java.util.Scanner;

/**
 * La clase 'SistemaCasilleros' es la clase principal que gestiona la lógica del programa.
 * Ahora maneja una cuadrícula de objetos 'Casillero', delegando las tareas a ellos.
 */
public class SistemaCasilleros {
    // La matriz 'casilleros' es la estructura principal, pero ahora de objetos 'Casillero'.
    private Casillero[][] casilleros;
    private int filas;
    private int columnas;
    private Scanner scanner;

    /**
     * Constructor para inicializar el sistema con un tamaño de filas y columnas.
     * Los casilleros se inicializan como vacíos.
     * @param filas El número de filas de la matriz de casilleros.
     * @param columnas El número de columnas de la matriz de casilleros.
     */
    public SistemaCasilleros(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        // Se crea la matriz bidimensional de Casillero.
        this.casilleros = new Casillero[filas][columnas];
        this.scanner = new Scanner(System.in);
        // Inicializa cada posición de la matriz con un nuevo objeto Casillero.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.casilleros[i][j] = new Casillero();
            }
        }
    }

    /**
     * Método para mostrar el menú principal y manejar las opciones del usuario.
     */
    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== SISTEMA DE CASILLEROS AMAZON ===");
            System.out.println("1. Registrar paquete en casillero");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Información de paquete en casillero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Importante para limpiar el buffer después de leer un número.
            
            switch (opcion) {
                case 1:
                    registrarPaquete();
                    break;
                case 2:
                    mostrarCasillerosDisponibles();
                    break;
                case 3:
                    mostrarInformacionPaquete();
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el sistema!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    /**
     * Método privado para registrar un paquete en un casillero específico.
     * Ahora usa la lógica de la clase Casillero.
     */
    private void registrarPaquete() {
        System.out.println("\n--- REGISTRAR PAQUETE ---");
        mostrarEsquemaCasilleros();
        
        System.out.print("Ingrese fila del casillero (0-" + (filas - 1) + "): ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese columna del casillero (0-" + (columnas - 1) + "): ");
        int columna = scanner.nextInt();
        scanner.nextLine();

        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.out.println("¡Ubicación no válida!");
            return;
        }
        
        Casillero casilleroSeleccionado = casilleros[fila][columna];
        if (!casilleroSeleccionado.estaVacio()) {
            System.out.println("¡Este casillero ya está ocupado!");
            return;
        }
        
        System.out.print("Ingrese nombre del destinatario: ");
        String destinatario = scanner.nextLine();
        
        // Se crea el objeto Paquete y se registra en el casillero.
        Paquete paqueteNuevo = new Paquete(destinatario);
        casilleroSeleccionado.registrarPaquete(paqueteNuevo);
        System.out.println("Paquete registrado exitosamente en casillero [" + fila + "," + columna + "]");
    }
    
    /**
     * Método privado para mostrar la lista de casilleros disponibles.
     */
    private void mostrarCasillerosDisponibles() {
        System.out.println("\n--- CASILLEROS DISPONIBLES ---");
        int disponibles = 0;
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casilleros[i][j].estaVacio()) {
                    System.out.println("Casillero [" + i + "," + j + "]: DISPONIBLE");
                    disponibles++;
                }
            }
        }
        
        System.out.println("Total de casilleros disponibles: " + disponibles + " de " + (filas * columnas));
    }
    
    /**
     * Método privado para mostrar la información de un paquete en un casillero.
     */
    private void mostrarInformacionPaquete() {
        System.out.println("\n--- INFORMACIÓN DE PAQUETE ---");
        System.out.print("Ingrese fila del casillero (0-" + (filas - 1) + "): ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese columna del casillero (0-" + (columnas - 1) + "): ");
        int columna = scanner.nextInt();
        
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.out.println("¡Ubicación no válida!");
            return;
        }
        
        Casillero casilleroSeleccionado = casilleros[fila][columna];
        if (casilleroSeleccionado.estaVacio()) {
            System.out.println("Este casillero está vacío.");
        } else {
            Paquete paquete = casilleroSeleccionado.getPaquete();
            System.out.println("Destinatario: " + paquete.getDestinatario());
            System.out.println("Fecha de ingreso: " + paquete.getFechaIngreso());
        }
    }
    
    /**
     * Método privado para mostrar un esquema visual de los casilleros.
     */
    private void mostrarEsquemaCasilleros() {
        System.out.println("\nEsquema de casilleros (O = Disponible, X = Ocupado):");
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(casilleros[i][j].estaVacio() ? "[O]" : "[X]");
            }
            System.out.println(); // Salto de línea para la siguiente fila.
        }
    }
    
    /**
     * Método principal de donde inicia la ejecución del programa.
     */
    public static void main(String[] args) {
        SistemaCasilleros sistema = new SistemaCasilleros(3, 4);
        sistema.mostrarMenu();
    }
}
