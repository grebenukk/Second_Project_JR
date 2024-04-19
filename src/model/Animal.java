package model;

import java.util.ArrayList;
import java.util.Map;

public abstract class Animal implements Runnable {
    protected int location = 1;
    protected double weight;
    protected double saturation;
    protected int speed;
    protected String imageAnimal;
    protected Map<String, Integer> diet;
    protected boolean accessToOutput = false;

    public void mealForPredator(ArrayList<Animal> herbivore) {

    }

    public void setOnTrueAccessToOutput() {
        accessToOutput = true;
    }
    public void setOnFalseAccessToOutput() {
        accessToOutput = false;
    }
    public boolean getAccessToOutput() {
        return accessToOutput;
    }
    public void mealForHerbivore() {

    }
    @Override
    public void run() {
        transfer();
    }

    public abstract void transfer();

    public int getLocation() {
        return location;
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
    public String getImageAnimal() {
        return imageAnimal;
    }
    public Map<String, Integer> getDiet() {
        return diet;
    }
}
