package Clase 3;

public class MatricesEstructuraDeDatos {
    public int[][] llenarMatriz(int filas, int columnas){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = (int) ((Math.random() * (20 - 1) + 1)) + 1; 

            }

         }
         return m;
    }


    public int[][] llenarMatriz(int filas, int columnas){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                cad += m[i][j];
            }
            cad += "\n";
        }
        return cad;
    }
}
