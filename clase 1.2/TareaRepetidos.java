import java.util.ArrayList;  // Para retornar una lista de arrays
import java.util.HashSet;    // Para seguir numeros unicos y/o repetidos
import java.util.List;       // Para declarar el tipo de retorno
import java.util.Set;        // para declarar las variables de HashSet

public class TareaRepetidos {
    public static List<Integer> encontrarRepetidos(int[] arreglo) { //List<Integer> es una lista que contiene
        //integros y solo integros, ni floats ni strings ni nada de eso
        Set<Integer> unicos = new HashSet<>(); //esta cosa de hash set es para que no se repitan numeros
        //osea, si hay dos "5", no se repiten
        Set<Integer> repetidos = new HashSet<>();
        //aqui usamos 2, el primero sigue numeros unicos que hemos visto una vez
        //el otro encuentra los numeros repetidos, si tienes (1, 2, 3, 2, 4, 5, 4), 
        //encontrara que 4 y 2 tienen repetidos
        
        for (int num : arreglo) {
            if (!unicos.add(num)) { //añade el numero a la array list, si añadir falla (porque ya existe)
                repetidos.add(num); //lo añade a duplicados LOL
            } //que es el "!", que hace ahí? es un suiche que convierte false a true y true a false
            //!false → true
            /*!true → false
            ------------------------------------------------------
            unicos.add(num)	    |!unicos.add(num) |Condicion final
            ------------------------------------------------------
            true (unique)	    |→ false          |Skip
            ------------------------------------------------------
            false (duplicate)	|→ true           |Ejecutar bloque 
            */
        }
        return new ArrayList<>(repetidos); //convierte el hashset de duplicados en un array list
        //lista que te dice "pilla, estos son todos lod uplicados"
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 2, 4, 5, 4};
        System.out.println("Repetidos: " + encontrarRepetidos(numeros));
    }
}