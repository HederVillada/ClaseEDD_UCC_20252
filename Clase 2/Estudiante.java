package Clase 2;

public class Estudiante{

    //atributos
    private String id;
    private String nombre;
    private String apellido;
    private String facultad;


    //constructor de la clase
    //tiene el mismo nombre de la clase
    public Estudiante(int id, String nombre, String apellido, String facultad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;
    }

    public int getid(){
        return id;
    }

    public void matricularCursos(int id, string[] cursos){
        for(int i = 0; i < cursos.length; i++);
    }
}
