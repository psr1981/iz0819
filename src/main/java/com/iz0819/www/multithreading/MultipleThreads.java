package com.iz0819.www.multithreading;

class newThread1 implements Runnable {
    Thread t;

    newThread1(String name) {
        t=new Thread(this, name);
        System.out.println("Child thread " + t);
    }

    @Override
    public void run() {
        try {
            for(int i = 5; i> 0; i--) {
                System.out.println("Child thread " + i );
                Thread.sleep(500);
            }
        } catch(InterruptedException e) {
            System.out.println("Child interrupted " + e );
        }
        System.out.println("Exiting child thread");
    }

}
public class MultipleThreads {
    public static void main(String args[])  {
        newThread1 nt1 = new newThread1("One");
        newThread1 nt2 = new newThread1("Two");
        newThread1 nt3 = new newThread1("Three");

        System.out.print("Starting new threads");

        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        System.out.println("Main thread");

        try {
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        }
        catch(InterruptedException e) {
            System.out.println("Child thread interrupted");
        }

        System.out.println("Main thread exiting");
    }
}
