package fr.croustibat.javaquarium.util.fishes.species;

import fr.croustibat.javaquarium.util.fishes.Carnivorous;

public class Merou extends Carnivorous {
    protected final int herma = 1;
    public Merou(String name, char gender) {
        super(name, gender);
    }

    public Merou(String name, char gender, int age) {
        super(name, gender, age);
    }

    @Override
    public int getHerma() {
        return this.herma;
    }
}
