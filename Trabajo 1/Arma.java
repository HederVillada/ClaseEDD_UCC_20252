package Arma;

public class Arma {
    protected String marca;
    protected int year;
    protected String model;

    public Arma(String marca, int year, String model) {
        this.marca = marca;
        this.year = year;
        this.model = model;
    }

    public void shoot() {
        System.out.println(marca + " " + model + " (" + year + ") dispara!");
    }
}
