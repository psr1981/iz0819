package com.iz0819.www.multithreading;

class Q {
    int num;
    boolean valueSet = false;

    public synchronized void put(int n) {
        while(valueSet){
            try { wait(); } catch(Exception e ) {}
        }
        this.num=n;
        System.out.println("put=" + this.num);
        valueSet=true;
        notify();
    }
    public synchronized int get() {
        while(!valueSet) {
            try { wait(); } catch(Exception e ) {}
        }
        System.out.println("get=" + this.num);
        valueSet=false;
        notify();
        return num;
    }
}

class Producer implements Runnable {
    Q q;
    public Producer(Q q1){
        this.q=q1;
        Thread t=new Thread(this, "com.iz0819.www.Producer");
        try { t.start(); } catch(Exception e) {}
    }
    public void run() {
        int i=0;
        while(true) {
            q.put(i++);
            try { Thread.sleep(1000); } catch(Exception e) {}

        }
    }
}

class Consumer implements Runnable {
    Q q;
    public Consumer(Q q1){
        this.q=q1;
        Thread t=new Thread(this, "com.iz0819.www.Consumer");
        try { t.start(); } catch(Exception e) {}
    }
    public void run() {
        int i=0;
        while(true) {
            q.get();
            try { Thread.sleep(1000); } catch(Exception e) {}

        }
    }
}

public class MultiThreadedProducerConsumer {
    public static void main(String ...args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
