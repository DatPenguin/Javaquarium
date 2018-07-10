package fr.croustibat.javaquarium.util;

import java.util.ArrayList;

public abstract class Fish extends Living {
    private String name;
    private char gender;
    private int size;
    private int weight;
    protected final int herma = 0;  // 0 : Mono-sexué, 1 : Hermaphrodite avec l'âge, 2 : Hermaphrodite opportuniste

    public Fish(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }

    public Fish(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public static void getOld(ArrayList<Fish> fL) {
        for (int i = 0; i < fL.size(); i++) {
            Fish f = fL.get(i);
            if (f.getAge() > 0)
                f.setAge(f.getAge() - 1);
            else {
                fL.remove(f);
                System.out.println("[POISSONS] " + f.getName() + " est mort(e) de vieillesse !");
            }
        }
    }

    public static void fishesStarve(ArrayList<Fish> fList) {
        for (int i = 0; i < fList.size(); i++) {
            Fish f = fList.get(i);
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

    public int getHerma() {
        return herma;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + ", " + gender + ", " + age + "] " + name;
    }
}
