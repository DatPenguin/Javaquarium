package fr.croustibat.javaquarium.util;

import java.util.ArrayList;

public class Alga extends Living {
    private String name;

    public Alga(String name) {
        this.name = name;
    }

    public static void algaeGrow(ArrayList<Alga> aList) {
        for (Alga a : aList)
            a.setHp(a.getHp() + 1);
    }
}
