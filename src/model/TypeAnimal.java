package model;

import java.util.Map;

public enum TypeAnimal {
    RABBIT(2, 0.45, 2, "\ud83d\udc30"),
    MOUSE(0.05, 0.01, 1, "\uD83D\uDC2D"),
    HORSE(400, 60, 4, "\ud83d\udc34"),
    WOLF(50, 8, 3, "\uD83D\uDC3A", Map.of("\ud83d\udc30", 60, "\uD83D\uDC2D", 80, "\ud83d\udc34", 10)),
    SNAKE(15, 3, 1, "\uD83D\uDC0D", Map.of("\uD83E\uDD8A", 15, "\ud83d\udc30", 20, "\uD83D\uDC2D", 40)),
    FOX(8, 2, 2, "\uD83E\uDD8A", Map.of("\ud83d\udc30", 70, "\uD83D\uDC2D", 90));

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
