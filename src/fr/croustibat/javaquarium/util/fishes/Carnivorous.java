package fr.croustibat.javaquarium.util.fishes;

import fr.croustibat.javaquarium.util.Fish;

public abstract class Carnivorous extends Fish {
    protected Carnivorous(String name, char gender) {
        super(name, gender);
    }

    protected Carnivorous(String name, char gender, int age) {
        super(name, gender, age);
    }
}
