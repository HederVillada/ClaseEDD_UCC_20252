import java.util.Random;

public class OperacionesArreglos {
    
    //metodo para llenar un arreglo de enteros
    public int[] llenarArreglo(int tam){


        Random rand = new Random();

        int[] numeros = new int[tam];
        for(int i = 0; i < numeros.length; i++){
            numeros[i] rand.nextInt(100 - 1) + 1;  //numeros del 1 al 100

        }

        return numeros;

        //sumar los elementos de un arreglo de enteros

        //obtener el promedio de un arreglo de enteros
        
        //obtener los numeros repetidos de un arreglo de enteros

        //obtener el mayor y el menor de un arreglo de enteros
    }
}
