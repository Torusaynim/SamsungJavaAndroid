package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HeroStatus hero = new HeroStatus();
        System.out.print("Введите имя ваше имя: ");
        hero.setHeroName(scan.nextLine());
        System.out.print("Введите имя сущности, которой хотите бросить вызов: ");
        Boss enemy = new Boss(scan.nextLine());
        System.out.println("ИГРА НАЧАЛАСЬ!");
        Game.start(hero, enemy);
    }
}
