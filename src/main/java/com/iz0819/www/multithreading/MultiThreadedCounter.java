package com.iz0819.www.multithreading;

class CounterX {
    int count=0;
    public synchronized int nextNumber() {
        return count++;
    }
}

class Thread1 implements Runnable {
    CounterX counter;
    int max;
    Thread1(CounterX counter, int max){
        this.counter=counter;
        this.max=max;
        Thread t = new Thread(this, "com.iz0819.www.Thread1");
        t.start();
    }

    @Override
    public void run() {
        for(int i=0; i<max;i++) {
            int n = counter.nextNumber();
            if (n % 2 ==0) {  System.out.println("com.iz0819.www.Thread1=" + n); }
            try { counter.wait(); } catch(Exception e ) {e.printStackTrace();}
            try { counter.notify(); } catch(Exception e ) {e.printStackTrace();}
        }
    }
}

class Thread2 implements Runnable {
    CounterX counter;
    int max;
    Thread2(CounterX counter, int max){
        this.counter=counter;
        this.max=max;
        Thread t = new Thread(this, "com.iz0819.www.Thread2");
        t.start();
    }

    @Override
    public void run() {
        for(int i=0; i<max;i++) {
            int n = counter.nextNumber();
            if (n%2 != 0) {  System.out.println("com.iz0819.www.Thread2=" + n); }
            try { counter.wait(); } catch(Exception e ) {e.printStackTrace();}
            try { counter.notify(); } catch(Exception e ) {e.printStackTrace();}
        }
    }
}

public class MultiThreadedCounter {
    public static void main(String args[]) {
        CounterX c = new CounterX();
        new Thread1(c,10);
        new Thread2(c,10);
    }
}
