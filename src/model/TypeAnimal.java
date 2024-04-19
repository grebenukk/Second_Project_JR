package model;

import java.util.Map;

public enum TypeAnimal {
    RABBIT(2, 0.45, 2, "\ud83d\udc30");

    private double weight;
    private double saturation;
    private int speed;
    private String imageAnimal;
    private Map<String, Integer> diet;

    TypeAnimal(double weight, double saturation, int speed, String imageAnimal, Map<String, Integer> diet) {
        this.weight = weight;
        this.saturation = saturation;
        this.speed = speed;
        this.imageAnimal = imageAnimal;
        this.diet = diet;
    }

    TypeAnimal(double weight, double saturation, int speed, String imageAnimal) {
        this.weight = weight;
        this.saturation = saturation;
        this.speed = speed;
        this.imageAnimal = imageAnimal;
        this.diet = Map.of();
    }

    public double getWeight() {
        return weight;
    }
    public double getSaturation() {
        return saturation;
    }
    public int getSpeed() {
        return speed;
    }
    public String getImagineAnimal() {
        return imageAnimal;
    }
    public Map<String, Integer> getDiet() {
        return diet;
    }
}
