package fr.croustibat.javaquarium.util.fishes;

import fr.croustibat.javaquarium.util.Fish;

public abstract class Herbivorous extends Fish {
    protected Herbivorous(String name, char gender) {
        super(name, gender);
    }

    protected Herbivorous(String name, char gender, int age) {
        super(name, gender, age);
    }

}
