package fr.croustibat.javaquarium.util.fishes;

import fr.croustibat.javaquarium.util.Fish;

public abstract class Carnivorous extends Fish {
    public Carnivorous(String name, char gender) {
        super(name, gender);
    }

    public Carnivorous(String name, char gender, int age) {
        super(name, gender, age);
    }

    public void eat(Fish f) {

    }
}
