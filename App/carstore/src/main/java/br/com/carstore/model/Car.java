package br.com.carstore.model;

public class Car {
    //private final String ID ;
    private final String name;//declarando uma variavel String nome constante.
    private final String color;//declarando a variavel color constante.

    public Car(String name, String color) {//Metodo construtor.
       // this.ID = ID;
        this.name = name;
        this.color = color;
    }

    public String getColor() {//metodo que pega a cor.
        return color;
    }

    public String getName() {//Metodo que pega o nome.
        return name;
    }

}
