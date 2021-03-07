package com.company;

public class Taker extends Thread {
    static boolean flag = true;
    public static int balance = 4000;
    public static int fee = 650;
    @Override
    public void run() {
        while(flag) {
            Main.take((int)(Math.random()*1000));
        }
    }
}
