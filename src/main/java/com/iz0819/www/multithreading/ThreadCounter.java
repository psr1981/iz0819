package com.iz0819.www.multithreading;

class Counter {
    long count = 0;
    String counterName = null;

    public Counter(String name) {
       this.counterName=name;
    }
    public synchronized void add (long value) {
        this.count += value;
    }
}

class CounterThread extends Thread  {
    protected Counter counter = null;

    public CounterThread(Counter c) {
        this.counter = c;
    }

    public void run() {
        for(int i=0; i<10;i++) {
            counter.add(i);
            System.out.println( counter.count);
        }
    }
}
public class ThreadCounter {
    public static void main(String args[]) {
        Counter counterA = new Counter("CounterA");
        Counter counterB = new Counter("CounterB");

        Thread threadA = new CounterThread(counterA);
        Thread threadB = new CounterThread(counterB);

        threadA.start();
        threadB.start();


    }
}
