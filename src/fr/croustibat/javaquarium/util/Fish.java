package fr.croustibat.javaquarium.util;

import java.util.ArrayList;

public class Fish extends Living {
    private String name;
    private char gender;
    private int size;
    private int weight;

    public Fish(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }

    public static void fishesStarve(ArrayList<Fish> fList) {
        for (Fish f : fList) {
            if (f.getHp() > 1)
                f.setHp(f.getHp() - 1);
            else
                fList.remove(f);
        }
    }

    public static ArrayList<Fish> wannaEat(ArrayList<Fish> fList) {
        ArrayList<Fish> hungryList = new ArrayList<>();

        for (Fish f : fList)
            if (f.getHp() <= 5)
                hungryList.add(f);
        return hungryList;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }
}
