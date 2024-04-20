package service;

import model.Animal;

import java.util.ArrayList;

public class OutputOnScreenAnimalsAndIsland implements Runnable {
    private static final FunctionalInterface<String> functionalInterface = () -> {
        ArrayList<String> strField = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            strField.add("_ ");
        }
        return strField;
    };

    private static final ArrayList<String> outputField = functionalInterface.cycle();

    public static ArrayList<String> getoutputField() {
        return outputField;
    }

    public  ArrayList<Animal> allAnimals;

    public  boolean checkOnTrue(){
        allAnimals  = StartService.getAllAnimalsList();
        for (Animal a: allAnimals){
            if (!a.getAccessToOutput()){
                return false;
            }
        }
        for (Animal a: allAnimals){
            a.setOnFalseAccessToOutput();
        }
        return true;
    }

    private void output() {
        if (checkOnTrue()) {

            for (int j = 1; j <= 200; j++) {
                System.out.print(outputField.get(j - 1));
                if (j % 20 == 0) {
                    System.out.println();
                }
                outputField.set(j - 1, "_ ");
            }
            System.out.println("\n\n");
        }
    }

    @Override
    public void run() {
        while (true) {
            output();
        }
    }
}