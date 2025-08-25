package Trabajo1;

public class Marca {
    private String marca;
    
    public Marca(String marca) {
        this.marca = marca;
    }
    
    public void printMarca() {
        System.out.println("Marca: " + marca);
    }
    
    // If you want to use scanner later
    public void setMarca(String newMarca) {
        this.marca = newMarca;
    }
}
