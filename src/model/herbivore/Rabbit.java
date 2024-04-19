package model.herbivore;

import model.Animal;
import model.TypeAnimal;

public class Rabbit extends Animal implements Runnable, Herbivore {
    public Rabbit() {
        weight = TypeAnimal.RABBIT.getWeight();
        saturation = TypeAnimal.RABBIT.getSaturation();
        speed = TypeAnimal.RABBIT.getSpeed();
        imageAnimal = TypeAnimal.RABBIT.getImagineAnimal();
    }

    @Override
    public void run() {

    }

    @Override
    public void transfer() {

    }
}
