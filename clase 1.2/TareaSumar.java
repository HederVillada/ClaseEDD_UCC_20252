public class TareaSumar {
    public static void main(String[] args) {
        // Se llama sumarElementos desde aqui
        int[] array = {1, 2, 3, 4, 5}; // array de pór ejemplos
        int resultado = sumarElementos(array);
        System.out.println("La suma es: " + resultado);
    }
    
    public static int sumarElementos(int[] arreglo) { //array de integros
        int suma = 0; 
        for (int num : arreglo) {  //Se usa un bucle for-each para recorrer cada numero del arreglo.
            suma += num; //Vamos acumulando cada número en la variable 
        }
        return suma; //se retorna el total
    }
}