package model.predator;

import service.FindFieldService;
import service.StartService;
import model.Animal;
import model.TypeAnimal;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Fox extends Animal implements Runnable, Predator {
    private static int firstStepOneTimeVariable = 1;

    public Fox() {
        weight = TypeAnimal.FOX.getWeight();
        saturation = TypeAnimal.FOX.getSaturation();
        speed = TypeAnimal.FOX.getSpeed();
        imageAnimal = TypeAnimal.FOX.getImagineAnimal();
        diet = TypeAnimal.FOX.getDiet();
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
        int randomStep = ThreadLocalRandom.current().nextInt(0, 5);
        int firstStep = firstStepOneTimeVariable;

        if (firstStep == 1) {
            firstStepOneTimeVariable++;
            location = ThreadLocalRandom.current().nextInt(1, 201);
            findFieldService.setField(this);
        } else if (location % 20 == 0) {
            location = ThreadLocalRandom.current().nextInt(location - 2, location + 1);
            findFieldService.setField(this);
        } else if (location - 1 % 20 == 0) {
            location = ThreadLocalRandom.current().nextInt(location, location + 3);
            findFieldService.setField(this);
        } else if (location == 199 || location == 198) {
            location = (location == 199) ? ThreadLocalRandom.current().nextInt(location - 2, location + 2) : ThreadLocalRandom.current().nextInt(location - 2, location + 3);
            findFieldService.setField(this);
        } else if (location < 62) {
            if (location >= 1 && location < 10) {
                if (randomStep == 3) {
                    location = ThreadLocalRandom.current().nextInt(location + 16, location + 23);
                    findFieldService.setField(this);
                } else if (randomStep == 4) {
                    location = ThreadLocalRandom.current().nextInt(location + 36, location + 43);
                    findFieldService.setField(this);
                }
            } else if (location >= 10 && location < 24) {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 2, location + 3);
                    findFieldService.setField(this);
                } else if (randomStep == 3) {
                    location = ThreadLocalRandom.current().nextInt(location + 16, location + 23);
                    findFieldService.setField(this);
                } else if (randomStep == 4) {
                    location = ThreadLocalRandom.current().nextInt(location + 36, location + 43);
                    findFieldService.setField(this);
                }
            } else if (location >= 24 && location < 44) {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 2, location + 3);
                    findFieldService.setField(this);
                } else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 22, location - 17);
                    findFieldService.setField(this);
                } else if (randomStep == 3) {
                    location = ThreadLocalRandom.current().nextInt(location + 16, location + 23);
                    findFieldService.setField(this);
                } else if (randomStep == 4) {
                    location = ThreadLocalRandom.current().nextInt(location + 36, location + 43);
                    findFieldService.setField(this);
                }
            } else if (randomStep == 0) {
                location = ThreadLocalRandom.current().nextInt(location - 2, location + 3);
                findFieldService.setField(this);
            } else if (randomStep == 1) {
                location = ThreadLocalRandom.current().nextInt(location - 22, location - 17);
                findFieldService.setField(this);
            } else if (randomStep == 2) {
                location = ThreadLocalRandom.current().nextInt(location - 42, location - 37);
                findFieldService.setField(this);
            } else if (randomStep == 3) {
                location = ThreadLocalRandom.current().nextInt(location + 16, location + 23);
                findFieldService.setField(this);
            } else if (randomStep == 4) {
                location = ThreadLocalRandom.current().nextInt(location + 36, location + 43);
                findFieldService.setField(this);
            }
        } else if (location > 136) {
            if (location <= 156) {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 2, location + 3);
                    findFieldService.setField(this);
                } else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 22, location - 17);
                    findFieldService.setField(this);
                } else if (randomStep == 2) {
                    location = ThreadLocalRandom.current().nextInt(location - 42, location - 37);
                    findFieldService.setField(this);
                } else if (randomStep == 3) {
                    location = ThreadLocalRandom.current().nextInt(location + 16, location + 23);
                    findFieldService.setField(this);
                } else if (randomStep == 4) {
                    location = ThreadLocalRandom.current().nextInt(location + 36, location + 43);
                    findFieldService.setField(this);
                }
            } else if (location <= 176) {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 2, location + 3);
                    findFieldService.setField(this);
                } else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 22, location - 17);
                    findFieldService.setField(this);
                } else if (randomStep == 2) {
                    location = ThreadLocalRandom.current().nextInt(location - 42, location - 37);
                    findFieldService.setField(this);
                } else if (randomStep == 3) {
                    location = ThreadLocalRandom.current().nextInt(location + 16, location + 23);
                    findFieldService.setField(this);
                }
            } else {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 2, location + 3);
                    findFieldService.setField(this);
                } else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 22, location - 17);
                    findFieldService.setField(this);
                } else if (randomStep == 2) {
                    location = ThreadLocalRandom.current().nextInt(location - 42, location - 37);
                    findFieldService.setField(this);
                }
            }
        } else {
            if (randomStep == 0) {
                location = ThreadLocalRandom.current().nextInt(location - 2, location + 3);
                findFieldService.setField(this);
            } else if (randomStep == 1) {
                location = ThreadLocalRandom.current().nextInt(location - 22, location - 17);
                findFieldService.setField(this);
            } else if (randomStep == 2) {
                location = ThreadLocalRandom.current().nextInt(location - 42, location - 37);
                findFieldService.setField(this);
            } else if (randomStep == 3) {
                location = ThreadLocalRandom.current().nextInt(location + 16, location + 23);
                findFieldService.setField(this);
            } else if (randomStep == 4) {
                location = ThreadLocalRandom.current().nextInt(location + 36, location + 43);
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