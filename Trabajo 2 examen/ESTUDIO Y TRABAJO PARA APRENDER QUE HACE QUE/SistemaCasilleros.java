import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

// La clase 'Paquete' representa un objeto de tipo paquete.
// Cada paquete tiene un destinatario y una fecha de ingreso al sistema.
class Paquete {
    private String destinatario; // Almacena el nombre de la persona a la que va el paquete.
    private Date fechaIngreso;   // Almacena la fecha y hora en que el paquete es registrado.
    
    // Constructor de la clase Paquete. Se llama al crear un nuevo paquete.
    public Paquete(String destinatario) {
        this.destinatario = destinatario;
        this.fechaIngreso = new Date(); // Asigna la fecha y hora actual al momento de la creación 
        //en el Date
    }
    
    // Método para obtener el nombre del destinatario.
    public String getDestinatario() {
        return destinatario;
    }
    
    // Método para obtener la fecha de ingreso en un formato legible.
    public String getFechaIngreso() {
        // SimpleDateFormat se usa para dar formato a la fecha (día/mes/año hora:minuto).
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formato.format(fechaIngreso);
    }
}

// La clase 'SistemaCasilleros' es la clase principal que gestiona la lógica del programa
// Este es el patron de las clases
public class SistemaCasilleros {
    // La matriz 'casilleros' es la estructura principal.
    // Representa la cuadrícula de casilleros, donde cada celda puede contener un objeto 'Paquete'.
    // En cada casillero va un paquete, entonces
    private Paquete[][] casilleros; //Paquete  array casilleros,aqui se usa array lists
    //Paquete[][] (doble brackets indican 2 dimensiones, la X y la Y)
    //Casilleros (porque cada casillero puede contener un paquete, es un grid de casilleros para paquetes) 
    private int filas;     // Número de filas en la matriz de casilleros (tipo X, horizontal)
    private int columnas;  // Número de columnas en la matriz de casilleros (tipo Y, vertical)
    //las 2 dimensiones del [][] son usadas, si lo ves? velo ve
    private Scanner scanner; // Objeto para leer la entrada del usuario desde la consola. El input
    
    // Constructor para inicializar el sistema con un tamaño de filas y columnas.
    public SistemaCasilleros(int filas, int columnas) {
        this.filas = filas; //estas filas son filas
        this.columnas = columnas; //y estas columnas son columnas
        // Se crea la matriz bidimensional con las dimensiones dadas.
        this.casilleros = new Paquete[filas][columnas];
        this.scanner = new Scanner(System.in);
    }
    // Método para mostrar el menú principal y manejar las opciones del usuario.
    public void mostrarMenu() {
        while (true) { // Coloque este bucle pa que no haya ningun chistosito colocando cosas que no son
            //y me crashee el programa
            System.out.println("\n=== SISTEMA DE CASILLEROS AMAZON ===");
            System.out.println("1. Registrar paquete en casillero");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Información de paquete en casillero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            //estas son las opciones, ahora veras el final del while
            
            int opcion = scanner.nextInt(); // Usa el escaner, el input de java, 
            //no se porque se llama scanner
            scanner.nextLine(); // Importante para limpiar el "buffer" del scanner 
            //después de leer un número. 
            //Inputs el SCANNER a las OPCIONES
            //Pero al hacerlo dejas el /n de sobra con el scanner input que siempre ocurre
            //Péro no quieres el /n
            //Utilizamos el scanner.nextLine y el scanner.nextLine usa el scanner
            //pero remueve el /n de sobra

                               // Esto evita problemas en la siguiente lectura de texto.
            
            // Un 'switch' para ejecutar el método correspondiente a la opción seleccionada.
            switch (opcion) {
                case 1:
                    registrarPaquete(); // Llama al método para registrar un paquete.
                    break;
                case 2:
                    mostrarCasillerosDisponibles(); // Llama al método para ver los casilleros libres.
                    break;
                case 3:
                    mostrarInformacionPaquete(); // Llama al método para ver la info de un paquete.
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el sistema!");
                    return; // Sale del método y finaliza el programa.
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    //Entonces puedes colocar cualquier input no valido pero el programa no se crashea

            }
        }
    }
    
    // Método privado para registrar un paquete en un casillero específico.
    private void registrarPaquete() {
        System.out.println("\n--- REGISTRAR PAQUETE ---");
        mostrarEsquemaCasilleros(); // Muestra el mapa visual de los casilleros.
        
        System.out.print("Ingrese fila del casillero (0-" + (filas-1) + "): "); // el X
        int fila = scanner.nextInt();
        System.out.print("Ingrese columna del casillero (0-" + (columnas-1) + "): "); //el Y
        int columna = scanner.nextInt(); //el scanner
        scanner.nextLine(); // Limpiar el /n.

        // Verifica si la fila y columna ingresadas están dentro de los límites de la matriz.
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.out.println("¡Ubicación no válida!");
            return; // Termina la ejecución del método. Las filas y columnas tienen que ser validas
            //o si no te salta el error de ubicacion no valida
        }
        
        // Verifica si el casillero en la posición elegida ya está ocupado
        if (casilleros[fila][columna] != null) {
            System.out.println("¡Este casillero ya está ocupado!");
            return;
        }
        
        System.out.print("Ingrese nombre del destinatario: ");
        String destinatario = scanner.nextLine(); // Lee el nombre del destinatario.
        //aqui coloca el scanner, ingrese el nombre pues tenes que ingresar el nombre
        
        // Crea un nuevo objeto Paquete y lo asigna a la celda de la matriz.
        // Este objeto es creado por el scanner
        casilleros[fila][columna] = new Paquete(destinatario);
        System.out.println("Paquete registrado exitosamente en casillero [" + fila + "," + columna + "]");
    }
    
    // Método privado para mostrar la lista de casilleros disponibles.
    private void mostrarCasillerosDisponibles() {
        System.out.println("\n--- CASILLEROS DISPONIBLES ---");
        int disponibles = 0;
        
        // Recorre cada celda de la matriz de casilleros para ver cuales hay, cuales no hay, y cuales
        //estan ocupados
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Si la celda es 'null', significa que está vacía y disponible.
                //Alli es donde metes tus paquetes, si no es null, no puedes meter el paquete
                if (casilleros[i][j] == null) {
                    System.out.println("Casillero [" + i + "," + j + "]: DISPONIBLE");
                    disponibles++; // Incrementa el contador de casilleros disponibles.
                    //Critico para el array, porque refleja cambios que se pueden hacer en el array
                    //Especialmente por las interacciones con el array gracias al scanner
                    //Si quitas este pedazo de codigo todo deja de funcionar
                   
                }
            }
        }
        
        System.out.println("Total de casilleros disponibles: " + disponibles + " de " + (filas * columnas));
    }

    
    // Método privado para mostrar la información de un paquete en un casillero.
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
            // Si hay un paquete, muestra su información.
            System.out.println("Destinatario: " + paquete.getDestinatario());
            System.out.println("Fecha de ingreso: " + paquete.getFechaIngreso());

        }
    }
    
    // Método privado para mostrar un esquema visual de los casilleros
    //El SOUT del casillero si esta ocupado o disponible, easy
    private void mostrarEsquemaCasilleros() {
        System.out.println("\nEsquema de casilleros (X = Ocupado, O = Disponible):");
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //los 2 loops van por cada uno, creando un grid, esto es justo lo que se hace en arrays
                // Usa un operador ternario para decidir si imprimir "[O]" o "[X]".
                //Esta medio complejo pero lo vimos en la clase
                System.out.print(casilleros[i][j] == null ? "[O]" : "[X]");
                //y aqui esta, arrays, casillero [i] (la que vimos que es X) y [j] (que es Y)
                //Si son null = O (si hay)
                //Si no = X (no hay)
            }
            System.out.println(); // Salto de línea para la siguiente fila.
        }
    }
    
    // Método principal de donde inicia la ejecución del programa.
    public static void main(String[] args) {
        // Se crea una instancia de la clase 'SistemaCasilleros' con 3 filas y 4 columnas.
        SistemaCasilleros sistema = new SistemaCasilleros(3, 4);
        sistema.mostrarMenu(); // Inicia el menú principal del sistema.
        //Y con este  public static void main string args (para el ejecutar)
        //Y ya con esto podemos ejecutarlo
    }
}
