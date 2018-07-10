package fr.croustibat.javaquarium.runnables;

import fr.croustibat.javaquarium.names.NameGenerator;

public class GetNames {
    public static void main(String[] args) {
        NameGenerator n = new NameGenerator();
        for (int i = 0; i < 10; i++)
            System.out.println(n.getName());
    }
}
