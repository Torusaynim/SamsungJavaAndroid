package com.company;

public abstract class Entity {
    private String type = "Shadow";
    public static int healthBar = 2000;
    abstract public int attack();
    abstract public int powerattack();
    abstract public int specialattack();
    abstract public void newturn();
    abstract public boolean entityAlive();

    public String getEntityType() { return type; };
}
