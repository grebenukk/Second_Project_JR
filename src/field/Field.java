package field;

import model.Animal;

import model.predator.Predator;
import service.OutputOnScreenAnimalsAndIsland;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Field {

    private final int numField;
    private ArrayList<String> outputField = OutputOnScreenAnimalsAndIsland.getoutputField();
    private int numGrass;
    private ArrayList<Animal> listAnimals = new ArrayList<>();

    public Field(int numField) {
        this.numField = numField;
        numGrass = ThreadLocalRandom.current().nextInt(100);
    }

    public void outputAnimals() throws InterruptedException {
        String outputAnimals = "";
        Thread.sleep(100);

        for (int i = 0; i < listAnimals.size(); i++) {
            outputAnimals += listAnimals.get(i).getImageAnimal();
        }

        outputField.set(numField, outputAnimals);
        for (int i = 0; i < listAnimals.size(); i++) {
            listAnimals.get(i).setOnTrueAccessToOutput();
        }
        Thread.sleep(950);
        outputField.set(numField, "_ ");
    }

    public void meal() {
        ArrayList<Animal> predator = new ArrayList<>();
        ArrayList<Animal> herbivore = new ArrayList<>();

        for (Animal listAnimals : listAnimals) {
            if (listAnimals instanceof Predator) {
                predator.add(listAnimals);
            } else {
                herbivore.add(listAnimals);
            }
        }

        if (!predator.isEmpty() && !herbivore.isEmpty()) {
            for (int i = 0; i < predator.size(); i++) {
                predator.get(i).mealForPredator(herbivore);
            }
        }

        if (!herbivore.isEmpty()) {
            for (int i = 0; i < herbivore.size(); i++) {
                if (numGrass == 0) {
                    numGrass += 50;
                } else {
                    numGrass--;
                }
            }
        }
        listAnimals.clear();
    }

    public void setListAnimals(Animal animal) {
        listAnimals.add(animal);

        try {
            outputAnimals();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        meal();
    }


}