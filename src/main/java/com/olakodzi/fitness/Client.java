package com.olakodzi.fitness;

public class Client {

    private String name;
    private double height;
    private double weight;
    private double bmi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
         return bmi = Math.round(weight /Math.pow(height, 2.0));
    }

}
