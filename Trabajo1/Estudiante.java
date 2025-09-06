package Trabajo1;

public class Estudiante {
    private String nombre; //nombre del estudiante
    private String matricula; //código o matrícula
    private double promedio; //nota promedio

    public Estudiante(String nombre, String matricula, double promedio) { //constructor para inicializar
        this.nombre = nombre;
        this.matricula = matricula;
        this.promedio = promedio;
    }

    public void mostrarInformacion() { //imprime los datos de un estudiante
        System.out.println(nombre + " (" + matricula + ") - Promedio: " + promedio);
    }

    // ===== Métodos de arreglo =====

    public void iterarEstudiantes(Estudiante[] lista) { //recorre un arreglo de estudiantes y 
        //muestra todos
        for (Estudiante e : lista) {
            if (e != null) e.mostrarInformacion();
        }
    }

    public int buscarPorMatricula(Estudiante[] lista, String matricula) { 
        //busca en el arreglo un estudiante con esa matrícula, devuelve la posición
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].matricula.equalsIgnoreCase(matricula)) {
                return i; //retorna índice si lo encuentra
            }
        }
        return -1; //si no existe, devuelve -1
    }

    public Estudiante[] eliminarPorMatricula(Estudiante[] lista, String matricula) { 
        //crea un nuevo arreglo sin el estudiante que tenga esa matrícula
        int pos = buscarPorMatricula(lista, matricula);
        if (pos < 0) return lista; //si no existe, devuelve el mismo arreglo

        Estudiante[] nueva = new Estudiante[lista.length - 1]; //nuevo arreglo más pequeño
        int idx = 0;
        for (int i = 0; i < lista.length; i++) {
            if (i != pos) nueva[idx++] = lista[i]; //copia todos excepto el eliminado
        }
        return nueva;
    }

    public Estudiante[] agregarEstudiante(Estudiante[] lista, Estudiante nuevo) { 
        //crea un arreglo más grande, copia los viejos, añade uno nuevo
        Estudiante[] nueva = new Estudiante[lista.length + 1];
        for (int i = 0; i < lista.length; i++) {
            nueva[i] = lista[i];
        }
        nueva[lista.length] = nuevo;
        return nueva;
    }

    public void actualizarPromedio(double nuevoPromedio) { 
        //cambia el promedio del estudiante
        this.promedio = nuevoPromedio;
    }
}
