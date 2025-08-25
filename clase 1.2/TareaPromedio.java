public class TareaPromedio {

    public static double obtenerPromedio(int[] arreglo) { //(int[] arreglo) crea un arreglo
        if (arreglo.length == 0) return 0; // Asi no se puede dividir por 0 y matarme la pc
        return (double) TareaSumar.sumarElementos(arreglo) / arreglo.length; 
        /*llama a sumarElementos de TareaSumar
        suma todos los numeros del array
        */
    }

    public static void main(String[] args) {
        int[] numeros = {5, 10, 15, 20, 25}; // Array de por ejemplis
        double promedio = obtenerPromedio(numeros); //obtenerPromedio reuses TareaSumar.sumarElementos
        System.out.println("El promedio es: " + promedio);
    }
}