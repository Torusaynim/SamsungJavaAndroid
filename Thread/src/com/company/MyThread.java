package com.company;

public class MyThread extends Thread {
    private String message;
    boolean flag = true;
    MyThread(String m) {
        this.message = m;
    }
    @Override
    public void run() {
        while(flag) {
            Main.test(message);
        }
    }
}
