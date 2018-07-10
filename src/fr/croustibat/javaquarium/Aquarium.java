package fr.croustibat.javaquarium;

import fr.croustibat.javaquarium.names.NameGenerator;
import fr.croustibat.javaquarium.util.Alga;
import fr.croustibat.javaquarium.util.Fish;
import fr.croustibat.javaquarium.util.fishes.Herbivorous;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;

public class Aquarium {
    private int turnNb = 0;
    private ArrayList<Fish> fishesList = new ArrayList<>();
    private ArrayList<Alga> algaeList = new ArrayList<>();
    private ArrayList<Fish> hungryList = new ArrayList<>();
    NameGenerator nG = new NameGenerator();

    public void addFish(Fish f) {
        fishesList.add(f);
    }

    public void addAlga(Alga a) {
        algaeList.add(a);
    }

    private void printStatus() {
        System.out.println("=== Tour " + turnNb + " ===");
        if (algaeList.size() > 0)
            System.out.println("[ALGUES] Il y a " + algaeList.size() + " algues");
        else
            System.out.println("[ALGUES] Il n'y a aucune algue.");

        if (fishesList.size() > 0) {
            System.out.println("[POISSONS] Il y a " + fishesList.size() + " poissons :");
            for (Fish f : fishesList)
                System.out.println(f.getName() + " (" + f.getClass().getSimpleName() + ", " + f.getGender() + " " + f.getAge() + ")");
        } else
            System.out.println("[POISSONS] Il n'y a aucun poisson.");
    }

    private void dinnerTime() {
        Random n = new Random();

        for (int i = 0; i < hungryList.size(); i++) { // Pour chaque poisson qui a faim
            Fish f = hungryList.get(i);
            if (f instanceof Herbivorous) {                                 // Si le poisson est herbivore
                Alga victim = algaeList.get(n.nextInt(algaeList.size()));   // On choisit une algue au hasard
                System.out.println("[HERBI] " + f.getName() + " a grignoté " + victim.getName());
                if (victim.getHp() > 2) {                                   // Si elle survit au grignotage
                    victim.setHp(victim.getHp() - 2);                       // Elle perd 2 HP
                    System.out.println("[ALGUES] " + victim.getName() + " a perdu 2 HP !");
                } else {                                                      // Sinon on la supprime
                    algaeList.remove(victim);
                    System.out.println("[ALGUES] " + victim.getName() + " est morte !");
                }
                f.setHp(f.getHp() + 3);                                     // Le poisson gagne 3 HP
            } else {                                                        // Sinon il s'agit d'un carnivore
                Fish victim = fishesList.get(n.nextInt(fishesList.size())); // On choisit un poisson au hasard
                if (!victim.getClass().equals(f.getClass())) {              // On compare les classes pour savoir si les poissons sont de la même espèce
                    System.out.println("[CARNI] " + f.getName() + " a croqué " + victim.getName());
                    if (victim.getHp() > 4) {                               // Si la victime survit à l'attaque
                        victim.setHp(victim.getHp() - 4);                   // Elle perd 4 HP
                        System.out.println("[POISSONS] " + victim.getName() + " a perdu 4 HP !");
                    } else {                                                  // Sinon on la supprime
                        fishesList.remove(victim);
                        System.out.println("[POISSONS] " + victim.getName() + " est mort(e) !");
                    }
                    f.setHp(f.getHp() + 5);                                 // Le prédateur gagne 5 HP
                }
            }
        }
    }

    private void zumbaTime() {
        Random n = new Random();

        for (int i = 0; i < fishesList.size(); i++) { // Pour chaque poisson
            Fish f = fishesList.get(i);
            if (f.getHp() <= 5)     // Poisson affamé ne trombine pas
                continue;
            Fish bae = fishesList.get(n.nextInt(fishesList.size()));    // On choisit un poisson au hasard
            if (bae.getClass().equals(f.getClass()) && bae.getGender() != f.getGender()) {                  // On compare les classes pour savoir si les poissons sont de la même espèce
                System.out.println("[ZUMBA] " + f.getName() + " a trombiné " + bae.getName());
                Fish son = mirrorMirror(bae.getClass().getName());
                System.out.println(son + " est né !");
                fishesList.add(son);
            }
        }

        for (int i = 0; i < algaeList.size(); i++) {
            Alga a = algaeList.get(i);
            if (a.getHp() < 10)
                continue;
            a.setHp(a.getHp() / 2);
            Alga son = new Alga(nG.getAlgaName());
            son.setHp(a.getHp());
            algaeList.add(son);
        }
    }

    private Fish mirrorMirror(String className) {
        Random r = new Random();
        int sex = r.nextInt(2);
        char gender;
        switch (sex) {
            case 0:
                gender = 'M';
                break;
            default:
                gender = 'F';
                break;
        }

        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(String.class, char.class, int.class);
            return (Fish) constructor.newInstance(nG.getName(), gender, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void newTurn() {
        turnNb++;
        Alga.getOld(algaeList);
        Fish.getOld(fishesList);
        Alga.algaeGrow(algaeList);
        Fish.fishesStarve(fishesList);
        hungryList = Fish.wannaEat(fishesList);
        if (!hungryList.isEmpty())
            dinnerTime();
        zumbaTime();
        printStatus();
    }

    /*
     * Exercices :
     * 3.2 :
     * Poissons : boucle semblable à celle de la nourriture mais prenant en compte le sexe, puis utilisation de addFish avec un âge 0.
     * Algues : Reproduction systématique dès que 10 HP ou plus.
     */
}
