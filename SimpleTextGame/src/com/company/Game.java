package com.company;

import java.util.Scanner;

public class Game {

    public static void start(HeroStatus hero, Boss enemy) {
        while (hero.heroAlive() && enemy.entityAlive()) {
            Game.battle(hero, enemy);
        }
        if (hero.heroAlive()) {
            System.out.println("Вы победили тёмную сущность, мир стал немного безопаснее!");
        } else {
            System.out.println("Вы пали в бою...");
            System.out.println("ИГРА ОКОНЧЕНА!");
        }
    }

    public static void battle(HeroStatus hero, Boss enemy) {
        Scanner scan = new Scanner(System.in);
        enemy.newturn();
        hero.incDMG = 1;
        int atktype;
        System.out.println("");
        System.out.println("ФАЗА ОБЪЯВЛЕНИЯ ДЕЙСТВИЙ:");
        System.out.println("Спец. очки "+enemy.getEntityType()+" "+enemy.getBossName()+": "+enemy.getChargecounter());
        if (enemy.getChargecounter() == 5) {
            System.out.println(enemy.getEntityType()+" "+enemy.getBossName()+" готовится применить специальную атаку");
            atktype = 3;
        } else {
            if (enemy.getChargecounter() >= 3) {
                if ((int)(Math.random() * 10) > 5) {
                    System.out.println(enemy.getEntityType()+" "+enemy.getBossName()+" готовится применить усиленную атаку");
                    atktype = 2;
                } else {
                    System.out.println(enemy.getEntityType()+" "+enemy.getBossName()+" пристально смотрит на вас и готовится к чему-то");
                    atktype = 0;
                }
            } else {
                System.out.println(enemy.getEntityType()+" "+enemy.getBossName()+" готовится атаковать");
                atktype = 1;
            }
        }
        int action;
        System.out.print("Ваши действия? 1 - атаковать, 0 - защищаться. Ваш выбор: ");
        do {
            action = scan.nextInt();
            if ((action != 0) && (action != 1)) System.out.println("Такого действия нет, 1 - атаковать, 0 - защищаться.");
        } while ((action != 0) && (action != 1));
        if (action == 1) System.out.println(hero.getHeroName()+" готовится атаковать");
        else System.out.println(hero.getHeroName()+" встаёт в защитную стойку");
        System.out.println("ФАЗА ОБЪЯВЛЕНИЯ ДЕЙСТВИЙ ОКОНЧЕНА");
        System.out.println("");
        System.out.println("ФАЗА БОЯ:");
        switch (action) {
            case 0: hero.defend();
                break;
            case 1: enemy.bossHit(hero.attack());
                break;
        }
        switch (atktype) {
            case 1: hero.heroHit(enemy.attack());
                break;
            case 2: hero.heroHit(enemy.powerattack());
                break;
            case 3: hero.heroHit(enemy.specialattack());
                break;
            default: break;
        }
        System.out.println("ФАЗА БОЯ ОКОНЧЕНА");
    }
}
