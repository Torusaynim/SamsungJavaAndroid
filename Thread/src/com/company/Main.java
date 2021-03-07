package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("+");
        t1.start();
        MyThread t2 = new MyThread("-");
        t2.start();
        Thread.sleep(3000);
        t1.flag = false;
        t1.join();
        test("1-st stopped");

    }
    private static Object key = new Object();
    public static void test (String m) {
        try {
            synchronized (key) {
                System.out.print("[");
                Thread.sleep(1000);
                System.out.print(m);
                Thread.sleep(1000);
                System.out.print("]");
                Thread.sleep(1000);
                //key.notify();
                //key.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
