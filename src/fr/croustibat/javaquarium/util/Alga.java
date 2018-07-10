package fr.croustibat.javaquarium.util;

import java.util.ArrayList;

public class Alga extends Living {
    private String name;

    public Alga(String name) {
        this.name = name;
    }

    public static void getOld(ArrayList<Alga> aL) {
        for (int i = 0; i < aL.size(); i++) {
            Alga a = aL.get(i);
            if (a.getAge() > 0)
                a.setAge(a.getAge() - 1);
            else {
                System.out.println("[ALGUES] " + a.getName() + " est morte de vieillesse !");
                aL.remove(a);
            }
        }
    }

    public String getName() {
        return name;
    }

    public static void algaeGrow(ArrayList<Alga> aList) {
        for (Alga a : aList)
            a.setHp(a.getHp() + 1);
    }
}
