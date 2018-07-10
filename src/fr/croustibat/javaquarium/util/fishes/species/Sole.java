package fr.croustibat.javaquarium.util.fishes.species;

import fr.croustibat.javaquarium.util.fishes.Herbivorous;

public class Sole extends Herbivorous {
    public Sole(String name, char gender) {
        super(name, gender);
    }

    public Sole(String name, char gender, int age) {
        super(name, gender, age);
    }

    @Override
    public int getHerma() {
        return 2;
    }
}
