package fr.croustibat.javaquarium.util.fishes;

import fr.croustibat.javaquarium.util.Fish;

public abstract class Carnivorous extends Fish {
    public Carnivorous(String name, char gender) {
        super(name, gender);
    }

    public void eat(Fish f) {

    }
}
