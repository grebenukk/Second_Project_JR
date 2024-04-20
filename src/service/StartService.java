package service;

import model.*;
import model.herbivore.Mouse;
import model.herbivore.Rabbit;
import model.predator.Fox;
import model.predator.Snake;
import model.predator.Wolf;
import model.herbivore.Horse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartService {
    private static OutputOnScreenAnimalsAndIsland outputOnScreenAnimalsAndIsland = new OutputOnScreenAnimalsAndIsland();
    private static Wolf wolf = new Wolf();
    private static Rabbit rabbit = new Rabbit();
    private static Snake snake = new Snake();
    private static Fox fox = new Fox();
    private static Mouse mouse = new Mouse();
    private static Horse horse = new Horse();
    private static List<Animal> allAnimals = new ArrayList<>(List.of(wolf, rabbit, snake, fox, mouse, horse));
    private static ExecutorService executorServiceWolf = Executors.newSingleThreadExecutor();
    private static ExecutorService executorServiceOutputOnScreenAnimalsAndIsland = Executors.newSingleThreadExecutor();
    private static ExecutorService executorServiceRabbit = Executors.newSingleThreadExecutor();
    private static ExecutorService executorServiceSnake = Executors.newSingleThreadExecutor();
    private static ExecutorService executorServiceFox = Executors.newSingleThreadExecutor();
    private static ExecutorService executorServiceMouse = Executors.newSingleThreadExecutor();
    private static ExecutorService executorServiceHorse = Executors.newSingleThreadExecutor();

    public static void closeMethode(Animal animalForCloseThread) {
        if (animalForCloseThread instanceof Rabbit) {
            executorServiceRabbit.shutdownNow();
            allAnimals.remove(rabbit);
        } else if (animalForCloseThread instanceof Mouse) {
            executorServiceMouse.shutdownNow();
            allAnimals.remove(mouse);
        } else if (animalForCloseThread instanceof Fox) {
            executorServiceFox.shutdownNow();
            allAnimals.remove(fox);
        } else if (animalForCloseThread instanceof Snake) {
            executorServiceSnake.shutdownNow();
            allAnimals.remove(snake);
        } else if (animalForCloseThread instanceof Horse) {
            executorServiceHorse.shutdownNow();
            allAnimals.remove(horse);
        }
    }

    public static ArrayList<Animal> getAllAnimalsList() {
        return (ArrayList) allAnimals;
    }

    public static void start() {
        executorServiceOutputOnScreenAnimalsAndIsland.submit(outputOnScreenAnimalsAndIsland);
        executorServiceWolf.submit(wolf);
        executorServiceRabbit.submit(rabbit);
        executorServiceSnake.submit(snake);
        executorServiceFox.submit(fox);
        executorServiceMouse.submit(mouse);
        executorServiceHorse.submit(horse);
    }
}
