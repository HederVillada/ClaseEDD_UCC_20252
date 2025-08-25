package Trabajo1;

public class Libro {
    private String titulo; //título del libro
    private String autor;  //autor del libro
    private double precio; //precio en plata

    public Libro(String titulo, String autor, double precio) { //constructor
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public void mostrarInformacion() { //muestra datos del libro
        System.out.println(titulo + " - " + autor + " : $" + precio);
    }

    // ===== Métodos de arreglo =====

    public double totalPrecio(Libro[] libros) { 
        //suma todos los precios de los libros
        double total = 0;
        for (Libro l : libros) {
            total += l.precio;
        }
        return total;
    }

    public void filtrarPorPrecioMayor(Libro[] libros, double umbral) { 
        //muestra los libros cuyo precio es mayor al umbral
        for (Libro l : libros) {
            if (l.precio > umbral) {
                l.mostrarInformacion();
            }
        }
    }

    public void ordenarPorPrecio(Libro[] libros) { 
        //ordena los libros de menor a mayor precio (burbuja)
        for (int i = 0; i < libros.length - 1; i++) {
            for (int j = 0; j < libros.length - 1 - i; j++) {
                if (libros[j].precio > libros[j + 1].precio) {
                    Libro tmp = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = tmp;
                }
            }
        }
    }

    public int buscarPorTitulo(Libro[] libros, String titulo) { 
        //busca un libro por su título en el arreglo
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].titulo.equalsIgnoreCase(titulo)) {
                return i; //retorna índice
            }
        }
        return -1; //si no existe
    }

    public void actualizarPrecio(double nuevoPrecio) { 
        //cambia el precio de ESTE libro
        this.precio = nuevoPrecio;
    }
}
