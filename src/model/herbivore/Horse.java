package model.herbivore;

import service.FindFieldService;
import model.Animal;
import model.TypeAnimal;

import java.util.concurrent.ThreadLocalRandom;

public class Horse extends Animal implements Runnable, Herbivore {
    private static int firstStepOneTimeVariable = 1;

    public Horse() {
        weight = TypeAnimal.HORSE.getWeight();
        saturation = TypeAnimal.HORSE.getSaturation();
        speed = TypeAnimal.HORSE.getSpeed();
        imageAnimal = TypeAnimal.HORSE.getImagineAnimal();
        diet = TypeAnimal.HORSE.getDiet();
    }

    @Override
    public void mealForHerbivore() {

    }

    @Override
    public void transfer() {
        FindFieldService findFieldService = new FindFieldService();
        int randomStep = ThreadLocalRandom.current().nextInt(0, 7);
        int firstStep = firstStepOneTimeVariable;

        if (firstStep == 1) {
            firstStepOneTimeVariable++;
            location = ThreadLocalRandom.current().nextInt(1, 201);
            findFieldService.setField(this);
        } else if (location % 20 == 0) {
            location = ThreadLocalRandom.current().nextInt(location - 1, location + 1);
            findFieldService.setField(this);
        } else if (location - 1 % 20 == 0) {
            location = ThreadLocalRandom.current().nextInt(location, location + 2);
            findFieldService.setField(this);
        } else if (location == 199 || location == 198) {
            location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
            findFieldService.setField(this);
        } else if (location < 62) {
            if (randomStep == 0) {
                location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                findFieldService.setField(this);
            } else if (randomStep == 1) {
                location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                findFieldService.setField(this);
            } else if (randomStep == 2) {
                location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                findFieldService.setField(this);
            }
        } else if (location > 136) {
            if (location <= 156) {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                    findFieldService.setField(this);
                } else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                    findFieldService.setField(this);
                } else if (randomStep == 2) {
                    location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                    findFieldService.setField(this);
                }
            } else if (location <= 176) {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                    findFieldService.setField(this);
                } else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                    findFieldService.setField(this);
                } else if (randomStep == 2) {
                    location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                    findFieldService.setField(this);
                }
            } else {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                    findFieldService.setField(this);
                } else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                    findFieldService.setField(this);
                }
            }
        } else {
            if (randomStep == 0) {
                location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                findFieldService.setField(this);
            } else if (randomStep == 1) {
                location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                findFieldService.setField(this);
            } else if (randomStep == 2) {
                location = ThreadLocalRandom.current().nextInt(location + 19, location + 20);
                findFieldService.setField(this);
            }
        }
    }


    @Override
    public void run() {
        while (true) {
            transfer();
        }
    }
}
