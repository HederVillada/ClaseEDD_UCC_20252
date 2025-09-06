import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

// La clase 'Paquete' representa un objeto de tipo paquete.
// Cada paquete tiene un destinatario y una fecha de ingreso al sistema.
class Paquete {
    private String destinatario;
    private Date fechaIngreso;
    
    public Paquete(String destinatario) {
        this.destinatario = destinatario;
        this.fechaIngreso = new Date();
    }
    
    public String getDestinatario() {
        return destinatario;
    }
    
    public String getFechaIngreso() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formato.format(fechaIngreso);
    }
}

// La clase 'SistemaCasilleros' es la clase principal que gestiona la lógica del programa
public class SistemaCasilleros {
    private Paquete[][] casilleros;
    private int filas;
    private int columnas;
    private Scanner scanner;
    
    public SistemaCasilleros(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casilleros = new Paquete[filas][columnas];
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== SISTEMA DE CASILLEROS AMAZON ===");
            System.out.println("1. Registrar paquete en casillero");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Información de paquete en casillero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
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
    
    private void registrarPaquete() {
        System.out.println("\n--- REGISTRAR PAQUETE ---");
        mostrarEsquemaCasilleros();
        
        System.out.print("Ingrese fila del casillero (0-" + (filas-1) + "): ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese columna del casillero (0-" + (columnas-1) + "): ");
        int columna = scanner.nextInt();
        scanner.nextLine();

        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.out.println("¡Ubicación no válida!");
            return;
        }
        
        if (casilleros[fila][columna] != null) {
            System.out.println("¡Este casillero ya está ocupado!");
            return;
        }
        
        System.out.print("Ingrese nombre del destinatario: ");
        String destinatario = scanner.nextLine();
        
        casilleros[fila][columna] = new Paquete(destinatario);
        System.out.println("Paquete registrado exitosamente en casillero [" + fila + "," + columna + "]");
    }
    
    private void mostrarCasillerosDisponibles() {
        System.out.println("\n--- CASILLEROS DISPONIBLES ---");
        int disponibles = 0;
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casilleros[i][j] == null) {
                    System.out.println("Casillero [" + i + "," + j + "]: DISPONIBLE");
                    disponibles++;
                }
            }
        }
        
        System.out.println("Total de casilleros disponibles: " + disponibles + " de " + (filas * columnas));
    }
    
    private void mostrarInformacionPaquete() {
        System.out.println("\n--- INFORMACIÓN DE PAQUETE ---");
        System.out.print("Ingrese fila del casillero (0-" + (filas-1) + "): ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese columna del casillero (0-" + (columnas-1) + "): ");
        int columna = scanner.nextInt();
        
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.out.println("¡Ubicación no válida!");
            return;
        }
        
        Paquete paquete = casilleros[fila][columna];
        if (paquete == null) {
            System.out.println("Este casillero está vacío.");
        } else {
            System.out.println("Destinatario: " + paquete.getDestinatario());
            System.out.println("Fecha de ingreso: " + paquete.getFechaIngreso());
        }
    }
    
    private void mostrarEsquemaCasilleros() {
        System.out.println("\nEsquema de casilleros (X = Ocupado, O = Disponible):");
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(casilleros[i][j] == null ? "[O]" : "[X]");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        SistemaCasilleros sistema = new SistemaCasilleros(3, 4);
        sistema.mostrarMenu();
    }
} 