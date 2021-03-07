package com.company;

public class Giver extends Thread {
    static boolean flag = true;
    @Override
    public void run() {
        while(flag) {
            Main.give((int)(Math.random()*1000));
        }
    }
}
