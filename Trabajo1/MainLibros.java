package Trabajo1;

public class MainLibros {
    public static void main(String[] args) {
        Libro[] biblioteca = new Libro[5]; //arreglo de 5 libros
        biblioteca[0] = new Libro("Sombra y Hueso", "Leigh Bardugo", 12.99);
        biblioteca[1] = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 18.50);
        biblioteca[2] = new Libro("1984", "George Orwell", 9.75);
        biblioteca[3] = new Libro("El Principito", "Antoine de Saint-Exupéry", 6.40);
        biblioteca[4] = new Libro("Clean Code", "Robert C. Martin", 34.99);

        System.out.println("=== Biblioteca ==="); 
        for (Libro l : biblioteca) l.mostrarInformacion(); //muestra todos los libros
        System.out.println();

        System.out.println("Total precios: $" + biblioteca[0].totalPrecio(biblioteca)); 
        //calcula y muestra la suma de precios
        System.out.println();

        System.out.println("=== Libros con precio > 10 ==="); 
        biblioteca[0].filtrarPorPrecioMayor(biblioteca, 10); //filtra y muestra solo libros caros
        System.out.println();

        System.out.println("=== Ordenar libros por precio (ascendente) ==="); 
        biblioteca[0].ordenarPorPrecio(biblioteca); //ordena por precio
        for (Libro l : biblioteca) l.mostrarInformacion(); //muestra ya ordenados
        System.out.println();

        System.out.println("=== Buscar libro '1984' y actualizar precio ==="); 
        int pos = biblioteca[0].buscarPorTitulo(biblioteca, "1984"); //busca por título
        if (pos >= 0) {
            biblioteca[pos].mostrarInformacion(); //muestra el libro encontrado
            biblioteca[pos].actualizarPrecio(11.99); //cambia el precio
            System.out.println("Después de actualización:");
            biblioteca[pos].mostrarInformacion(); //muestra actualizado
        }
    }
}
