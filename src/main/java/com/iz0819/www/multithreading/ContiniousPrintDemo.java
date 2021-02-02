package com.iz0819.www.multithreading;

class CounterY {
    volatile boolean isEven = true;

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean isEven) {
        this.isEven = isEven;
    }

}

class EvenThread implements Runnable {
    CounterY count;

    EvenThread(CounterY c) {
        this.count=c;
        Thread t = new Thread(this, "com.iz0819.www.EvenThread");
        t.start();
    }

    @Override
    public void run() {
        synchronized (count) {
            for(int i=0;i<10;i+=2) {
                if (!count.isEven()) {
                    try {  count.wait(); } catch(Exception e) { e.printStackTrace(); }
                }
                System.out.println("Even " + i );
                count.isEven=false;
                try {  count.notify(); } catch(Exception e) { e.printStackTrace(); }
            }
        }
    }
}

class OddThread implements Runnable {
    CounterY count;

    OddThread(CounterY c) {
        this.count=c;
        Thread t = new Thread(this, "com.iz0819.www.OddThread");
        t.start();
    }

    @Override
    public void run() {
        synchronized (count) {
            for(int i=1;i<10;i+=2) {
                if (count.isEven()) {
                    try {  count.wait(); } catch(Exception e) { e.printStackTrace(); }
                }
                System.out.println("Odd " + i );
                count.isEven=true;
                try {  count.notify(); } catch(Exception e) { e.printStackTrace(); }
            }
        }
    }
}

public class ContiniousPrintDemo {

    public static void main(String[] args) {

        CounterY count = new CounterY();

        new EvenThread(count);
        new OddThread(count);

    }

}
