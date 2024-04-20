package model.predator;

import service.FindFieldService;
import service.StartService;
import model.Animal;
import model.TypeAnimal;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Snake extends Animal implements Runnable, Predator {
    private static int firstStepOneTimeVariable = 1;

    public Snake() {
        weight = TypeAnimal.SNAKE.getWeight();
        saturation = TypeAnimal.SNAKE.getSaturation();
        speed = TypeAnimal.SNAKE.getSpeed();
        imageAnimal = TypeAnimal.SNAKE.getImagineAnimal();
        diet = TypeAnimal.SNAKE.getDiet();
    }

    @Override
    public void mealForPredator(ArrayList<Animal> herbivore) {
        double percent;
        for (Animal animal : herbivore) {
            percent = diet.get(animal.getImageAnimal());

            if (percent >= ThreadLocalRandom.current().nextInt(111)) {
                StartService.closeMethode(animal);
            }
        }
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
            if (location >= 1 && location < 10) {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                    findFieldService.setField(this);
                }
            } else if (location >= 10 && location < 24) {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                    findFieldService.setField(this);
                } else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                    findFieldService.setField(this);
                }
            } else if (location >= 24 && location < 44) {
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
            } else if (randomStep == 0) {
                location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                findFieldService.setField(this);
            } else if (randomStep == 1) {
                location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
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