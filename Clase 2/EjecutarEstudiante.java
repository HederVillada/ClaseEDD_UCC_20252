import java.util.Arrays;

public class EjecutarEstudiante{

    public static void main(String[] args){

        Estudiante objEst1 = new Estudiante(19632304, "Andreas", "Nachtnebel", "Administracion");
        Estudiante objEst2 = new Estudiante(19662005, "Leslie", "König", "Ingenieria");
        Estudiante objEst3 = new Estudiante(19600507, "Daniela", "Martinez", "Psicologia");

        System.out.println(objEst1);
        System.out.println(objEst2);
        System.out.println(objEst3);

        System.out.println("--------------------------------------------");

        //crear rreglo de objetos
        //int[a] = new int[5]
        est[0] = objEst1;
        est[1] = objEst2;
        est[2] = objEst3;

        Arrays.toString(est);

        //Estudiante[] est = new Estudiante[5];
        //que se guarda en esta cadena? Estudiante, est,
        //si se guarda el objEst1, objEst2, objEst3
        /*
         * pero hay otra forma
         * en esta posicion
         * Est[0] = new Estudiante {
         * }
         */

         System.out.println(Arrays.toString(est));

         forEach(est: estudiantes){
            System.out.println(estudiantes);

            //forma 2
         }

         System.out.println();
         }
    }


    //tarea
    /*
     * implementar el metodo matricularCursos(id:int, cursos[]:String):void
     * implementa un metodo que permta saber cuantos estudiantes hay en cada facultad
     * implementar un metodo que permita saber cuantos estudiantes hay en cada curso
     * 
     * mera tarea lololol
     * 
     * 
     * 
     */
}