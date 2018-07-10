package fr.croustibat.javaquarium.util.fishes.species;

import fr.croustibat.javaquarium.util.fishes.Carnivorous;

public class PoissonClown extends Carnivorous {
    public PoissonClown(String name, char gender) {
        super(name, gender);
    }

    public PoissonClown(String name, char gender, int age) {
        super(name, gender, age);
    }

    @Override
    public int getHerma() {
        return 2;
    }
}
