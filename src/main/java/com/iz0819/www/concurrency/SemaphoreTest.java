package com.iz0819.www.concurrency;

import java.util.concurrent.*;

class Shared {
    static int count=0;
}

class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread( Semaphore s, String n ){
        this.name = n;
        this.sem  = s;
    }

    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for a permit");
            sem.acquire();
            for(int i=0;i<5;i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        }
        catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println(name + " releases the permit");
        sem.release();
    }
}

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread( Semaphore s, String n ){
        this.name = n;
        this.sem  = s;
    }

    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for a permit");
            sem.acquire();
            for(int i=0;i<5;i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        }
        catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println(name + " releases the permit");
        sem.release();
    }
}

public class SemaphoreTest {
    public static void main(String args[]) {
        Semaphore sem = new Semaphore(1);
        new Thread(new IncThread(sem, "A")).start();
        new Thread(new DecThread(sem, "B")).start();

    }
}
