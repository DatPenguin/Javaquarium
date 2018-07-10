package fr.croustibat.javaquarium.util.fishes;

import fr.croustibat.javaquarium.util.Alga;
import fr.croustibat.javaquarium.util.Fish;

public abstract class Herbivorous extends Fish {
    public Herbivorous(String name, char gender) {
        super(name, gender);
    }

    public Herbivorous(String name, char gender, int age) {
        super(name, gender, age);
    }

    public void eat(Alga a) {

    }
}
