package fr.croustibat.javaquarium;

import fr.croustibat.javaquarium.util.Alga;
import fr.croustibat.javaquarium.util.Fish;

import java.util.ArrayList;

public class Aquarium {
    private int turnNb = 0;
    private ArrayList<Fish> fishesList = new ArrayList<>();
    private ArrayList<Alga> algaeList = new ArrayList<>();
    private ArrayList<Fish> hungryList = new ArrayList<>();

    public void addFish(String name, char gender) {
        fishesList.add(new Fish(name, gender));
    }

    public void addAlga(String name) {
        algaeList.add(new Alga(name));
    }

    private void printStatus() {
        System.out.println("=== Tour " + turnNb + " ===");
        if (algaeList.size() > 0)
            System.out.println("Il y a " + algaeList.size() + " algues");
        else
            System.out.println("Il n'y a aucune algue.");

        if (fishesList.size() > 0) {
            System.out.println("Liste des poissons :");
            for (Fish f : fishesList)
                System.out.println(f.getName() + "(" + f.getGender() + ")");
        } else
            System.out.println("Il n'y a aucun poisson.");
    }

    private void dinnerTime() {
        //TODO
    }

    public void newTurn() {
        turnNb++;
        Alga.algaeGrow(algaeList);
        Fish.fishesStarve(fishesList);
        hungryList = Fish.wannaEat(fishesList);
        dinnerTime();
        printStatus();
    }
}
