package com.company;

public class Main {

    public static int pool = 1000;

    public static void main(String[] args) {
        Giver company = new Giver();
        company.start();
        Taker IE = new Taker();
        IE.start();
    }

    private static Object key = new Object();

    public static void give(int summ) {
        try {
            synchronized (key) {
                pool += summ;
                System.out.println("Company invested " + summ + "$ to shared account. POOL: " + pool + "$, IE: " + Taker.balance + "$");
                Thread.sleep(3000);
                key.notify();
                key.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void take(int summ) {
            try {
                synchronized (key) {
                    if (summ <= pool) {
                        pool -= summ;
                        Taker.balance += summ;
                        System.out.println("IE took " + summ + "$ from shared account. POOL: " + pool + "$, IE: " + Taker.balance + "$");
                        Thread.sleep(3000);
                    } else {
                        Taker.balance += pool;
                        System.out.println("IE took " + pool + "$ from shared account. POOL: " + 0 + "$, IE: " + Taker.balance + "$");
                        pool -= pool;
                        Thread.sleep(3000);
                    }
                    if (Taker.balance >= Taker.fee) {
                        Taker.balance -= Taker.fee;
                        System.out.println("IE paid it's fees(" + Taker.fee + "$). New IE: " + Taker.balance + "$");
                        Thread.sleep(3000);
                    } else {
                        Taker.balance -= Taker.fee;
                        Taker.flag = false;
                        Giver.flag = false;
                        System.out.println("IE RUN BANKRUPT! POOL: " + pool + "$, IE: " + Taker.balance + "$");
                        System.out.print("G A M E    O V E R !");
                    }
                    key.notify();
                    key.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
