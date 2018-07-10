package fr.croustibat.javaquarium.util.fishes.species;

import fr.croustibat.javaquarium.util.fishes.Herbivorous;

public class Bar extends Herbivorous {
    protected final int herma = 1;
    public Bar(String name, char gender) {
        super(name, gender);
    }

    public Bar(String name, char gender, int age) {
        super(name, gender, age);
    }

    @Override
    public int getHerma() {
        return this.herma;
    }
}
