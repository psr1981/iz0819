package com.iz0819.www.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class BarAction implements Runnable {
    public void run() {
        System.out.println("Barrier Reached");
    }
}

class MyThread1 implements Runnable {
    String name;
    CyclicBarrier cbar;

    MyThread1(String n, CyclicBarrier c) {
        this.name=n;
        this.cbar=c;
    }

    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (BrokenBarrierException ex) {
            System.out.println(ex);
        }
        catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}

public class CyclicBarrierDemo {
    public static void main(String argsp[]) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        System.out.println("Starting");
        new Thread(new MyThread1("A",cb)).start();;
        new Thread(new MyThread1("B",cb)).start();;
        new Thread(new MyThread1("C",cb)).start();;

    }
}
