package fr.croustibat.javaquarium.names;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
    private final ArrayList<String> names = new ArrayList<>();
    private final ArrayList<String> adj = new ArrayList<>();

    public NameGenerator() {
        try {
            Scanner s = new Scanner(new File("rsc/noms.txt"));
            while (s.hasNext())
                names.add(s.next());
            s = new Scanner(new File("rsc/adjectifs.txt"));
            while (s.hasNext())
                adj.add(s.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        Random r = new Random();
        return names.get(r.nextInt(names.size())) + "_" + adj.get(r.nextInt(adj.size()));
    }

    public String getAlgaName() {
        Random r = new Random();
        return names.get(r.nextInt(names.size()));
    }
}
