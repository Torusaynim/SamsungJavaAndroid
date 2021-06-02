package com.company;

public class HeroStatus {
    private static String name;
    public static int health = 500;
    public static double incDMG = 1;

    public boolean heroAlive() {
        if (health > 0) return true;
        else return false;
    }

    public void setHeroName(String name) {
        this.name = name;
    }

    public String getHeroName() {
       return name;
    }

    public void defend() {
        incDMG = 0.2;
    }

    public int attack() {
        return 160 + (int)(Math.random() * 10);
    }

    public void heroHit(int dmg) {
        health -= dmg;
        System.out.println(name+" получил "+dmg+" урона, текущее здоровье: "+health);
    }
}
