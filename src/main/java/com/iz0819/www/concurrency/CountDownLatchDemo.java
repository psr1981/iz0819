package com.iz0819.www.concurrency;

import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable {
    CountDownLatch latch;

    MyThread(CountDownLatch c) {
        this.latch=c;
    }

    @Override
    public void run() {
        for(int i=0; i<5;i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}

public class CountDownLatchDemo {

    public static void main(String args[]) {
        CountDownLatch cdl = new CountDownLatch(5);

        System.out.println("Starting..");

        new Thread(new MyThread(cdl)).start();

        try {
            cdl.await();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Done");
    }
}
