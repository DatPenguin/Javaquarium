package fr.croustibat.javaquarium.runnables;

import fr.croustibat.javaquarium.Aquarium;
import fr.croustibat.javaquarium.names.NameGenerator;
import fr.croustibat.javaquarium.util.Alga;
import fr.croustibat.javaquarium.util.Fish;
import fr.croustibat.javaquarium.util.fishes.species.*;

import java.util.Random;

public class Run {
    private static Fish fishGenerator() {
        NameGenerator nG = new NameGenerator();
        Random r = new Random();
        char sex;
        switch (r.nextInt(2)) {
            case 0:
                sex = 'M';
                break;
            default:
                sex = 'F';
                break;
        }

        Fish f;
        switch (r.nextInt(6)) {
            case 0:
                f = new Bar(nG.getName(), sex);
                break;
            case 1:
                f = new Carpe(nG.getName(), sex);
                break;
            case 2:
                f = new Merou(nG.getName(), sex);
                break;
            case 3:
                f = new PoissonClown(nG.getName(), sex);
                break;
            case 4:
                f = new Sole(nG.getName(), sex);
                break;
            case 5:
                f = new Thon(nG.getName(), sex);
                break;
            default:
                f = null;
                break;
        }
        return f;
    }

    private static Alga algaGenerator() {
        NameGenerator nG = new NameGenerator();
        return new Alga(nG.getAlgaName());
    }

    public static void main(String[] args) {
        Aquarium a = new Aquarium();
        for (int i = 0; i < 5; i++)
            a.addFish(fishGenerator());
        for (int i = 0; i < 5; i++)
            a.addAlga(algaGenerator());

        for (int i = 0; i < 15; i++)
            a.newTurn();
    }

}
