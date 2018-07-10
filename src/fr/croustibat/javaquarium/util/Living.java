package fr.croustibat.javaquarium.util;

import java.util.Random;

public abstract class Living {
    private int hp = 10;
    private int age;

    public Living() {
        Random r = new Random();
        age = r.nextInt(20) + 1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
