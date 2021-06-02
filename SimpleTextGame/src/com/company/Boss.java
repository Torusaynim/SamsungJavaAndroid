package com.company;

public class Boss extends Entity{
    private static int chargecounter = 0;
    private String name;

    Boss(String name) {
        this.name = name;
    }

    @Override
    public int attack() {
        return (int)((20 + (int)(Math.random() * 10) % 5) * HeroStatus.incDMG);
    }

    @Override
    public int powerattack() {
        chargecounter -= 3;
        return (int)((40 + (int)(Math.random() * 10) % 5) * HeroStatus.incDMG);
    }

    @Override
    public int specialattack() {
        chargecounter -= 5;
        return (int)((100 + (int)(Math.random() * 100)) * HeroStatus.incDMG);
    }

    @Override
    public void newturn() {
        chargecounter++;
    }

    @Override
    public boolean entityAlive() {
        if (healthBar > 0) return true;
        else return false;
    }

    public void bossHit(int dmg) {
        healthBar -= dmg;
        System.out.println(this.getEntityType()+" "+name+" получил "+dmg+" урона, текущее здоровье: "+healthBar);
    }

    public String getBossName() { return name; }

    public int getChargecounter() { return chargecounter; }
}
