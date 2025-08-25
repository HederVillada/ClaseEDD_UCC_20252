public class TareaMayorMenor {
    public static int[] encontrarMayorMenor(int[] arreglo) {
        if (arreglo.length == 0) return new int[]{0, 0};
        
        int mayor = arreglo[0];
        int menor = arreglo[0];
        
        for (int num : arreglo) {
            if (num > mayor) mayor = num;
            if (num < menor) menor = num;
        }
        return new int[]{mayor, menor};
    }

    public static void main(String[] args) {
        int[] numeros = {5, 10, -3, 20, 1};
        int[] resultado = encontrarMayorMenor(numeros);
        System.out.println("Mayor: " + resultado[0] + ", Menor: " + resultado[1]);
    }
}