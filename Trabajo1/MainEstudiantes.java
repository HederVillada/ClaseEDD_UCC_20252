package Trabajo1;

public class MainEstudiantes {
    public static void main(String[] args) {
        Estudiante[] curso = new Estudiante[3]; //crea un arreglo de 3 estudiantes (todavía vacío)
        curso[0] = new Estudiante("Dani", "MAT001", 4.8); //asigna 
        //estudiante en posición 0
        curso[1] = new Estudiante("Andreas", "MAT002", 4.5); //asigna 
        //estudiante en posición 1
        curso[2] = new Estudiante("Leslie", "MAT003", 4.2); //asigna 
        //estudiante en posición 2

        System.out.println("=== Lista inicial ==="); //imprime un título en pantalla
        curso[0].iterarEstudiantes(curso); //usa el método de la clase Estudiante para recorrer 
        //y mostrar todos los estudiantes
        System.out.println(); //salto de línea (línea vacía en consola)

        System.out.println("=== Buscar MAT002 ==="); //escribe "Buscar MAT002"
        int pos = curso[0].buscarPorMatricula(curso, "MAT002"); //busca en el arreglo quién 
        //tiene matrícula "MAT002"
        if (pos >= 0) curso[pos].mostrarInformacion(); //si lo encuentra (índice válido), imprime su info
        System.out.println(); //salto de línea

        System.out.println("=== Eliminar MAT003 ==="); //imprime título
        curso = curso[0].eliminarPorMatricula(curso, "MAT003"); //llama el 
        //método que devuelve un nuevo arreglo sin MAT003
        curso[0].iterarEstudiantes(curso); //muestra la lista actualizada de estudiantes
        System.out.println(); //salto de línea

        System.out.println("=== Agregar nuevo estudiante ==="); //título
        curso = curso[0].agregarEstudiante(curso, new Estudiante("John", "MAT004", 3.9)); 
        //agrega un nuevo estudiante al final del arreglo creando uno nuevo más grande 
        //y copiando los datos
        curso[0].iterarEstudiantes(curso); //muestra la lista otra vez
        System.out.println(); //salto de línea

        System.out.println("=== Actualizar promedio de MAT001 ==="); //título
        pos = curso[0].buscarPorMatricula(curso, "MAT001"); //busca dónde está el 
        //estudiante con matrícula MAT001
        if (pos >= 0) {
            curso[pos].actualizarPromedio(4.9); //si existe, le cambia el promedio a 4.9
            curso[pos].mostrarInformacion(); //y muestra su info actualizada
        }
    }
}
