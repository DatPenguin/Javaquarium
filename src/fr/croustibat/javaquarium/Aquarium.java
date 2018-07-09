package fr.croustibat.javaquarium;

import fr.croustibat.javaquarium.util.Alga;
import fr.croustibat.javaquarium.util.Fish;
import fr.croustibat.javaquarium.util.fishes.Herbivorous;

import java.util.ArrayList;
import java.util.Random;

public class Aquarium {
    private int turnNb = 0;
    private ArrayList<Fish> fishesList = new ArrayList<>();
    private ArrayList<Alga> algaeList = new ArrayList<>();
    private ArrayList<Fish> hungryList = new ArrayList<>();

    private void printStatus() {
        System.out.println("=== Tour " + turnNb + " ===");
        if (algaeList.size() > 0)
            System.out.println("[ALGUES] Il y a " + algaeList.size() + " algues");
        else
            System.out.println("[ALGUES] Il n'y a aucune algue.");

        if (fishesList.size() > 0) {
            System.out.println("[POISSONS] Liste des poissons :");
            for (Fish f : fishesList)
                System.out.println("[POISSONS] " + f.getName() + "(" + f.getGender() + ")");
        } else
            System.out.println("[POISSONS] Il n'y a aucun poisson.");
    }

    private void dinnerTime() {
        Random n = new Random();

        for (Fish f : hungryList) { // Pour chaque poisson qui a faim
            if (f instanceof Herbivorous) {                                 // Si le poisson est herbivore
                Alga victim = algaeList.get(n.nextInt(algaeList.size()));   // On choisit une algue au hasard
                if (victim.getHp() > 2)                                     // Si elle survit au grignotage
                    victim.setHp(victim.getHp() - 2);                       // Elle perd 2 HP
                else                                                        // Sinon on la supprime
                    algaeList.remove(victim);
                f.setHp(f.getHp() + 3);                                     // Le poisson gagne 3 HP
            } else {                                                        // Sinon il s'agit d'un carnivore
                Fish victim = fishesList.get(n.nextInt(fishesList.size())); // On choisit un poisson au hasard
                if (!victim.getClass().equals(f.getClass())) {              // On compare les classes pour savoir si les poissons sont de la même espèce
                    if (victim.getHp() > 4)                                 // Si la victime survit à l'attaque
                        victim.setHp(victim.getHp() - 4);                   // Elle perd 4 HP
                    else                                                    // Sinon on la supprime
                        fishesList.remove(victim);
                    f.setHp(f.getHp() + 5);                                 // Le prédateur gagne 5 HP
                }
            }
        }
    }

    public void newTurn() {
        turnNb++;
        Alga.algaeGrow(algaeList);
        Fish.fishesStarve(fishesList);
        hungryList = Fish.wannaEat(fishesList);
        if (!hungryList.isEmpty())
            dinnerTime();
        printStatus();
    }

    /*
     * Exercices :
     * 3.1 : fonction addFish / addAlga ajoutant un poisson / une algue avec un nom aléatoire (générateur de noms ?) et un âge aléatoire. Ajouter une variable âge
     * initialisée entre 0 et 20, et qui décroît à chaque tour. Dès que 0, on supprime.
     *
     * 3.2 :
     * Poissons : boucle semblable à celle de la nourriture mais prenant en compte le sexe, puis utilisation de addFish avec un âge 0.
     * Algues : Reproduction systématique dès que 10 HP ou plus.
     */
}
