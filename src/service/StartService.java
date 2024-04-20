package service;

import model.Animal;
import model.herbivore.Rabbit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartService {
    private static OutputOnScreenAnimalsAndIsland outputOnScreenAnimalsAndIsland = new OutputOnScreenAnimalsAndIsland();
    private static Rabbit rabbit = new Rabbit();
    private static List<Animal> allAnimals = new ArrayList<>(List.of(rabbit));
    private static ExecutorService executorServiceOutputOnScreenAnimalsAndIsland = Executors.newSingleThreadExecutor();
    private static ExecutorService executorServiceRabbit = Executors.newSingleThreadExecutor();

    public static void closeMethode(Animal animalForCloseThread) {
        if (animalForCloseThread instanceof Rabbit) {
            executorServiceRabbit.shutdownNow();
            allAnimals.remove(rabbit);
        }
    }

    public static ArrayList<Animal> getAllAnimalsList() {
        return (ArrayList) allAnimals;
    }

    public static void start() {
        executorServiceOutputOnScreenAnimalsAndIsland.submit(outputOnScreenAnimalsAndIsland);
        executorServiceRabbit.submit(rabbit);
    }
}
