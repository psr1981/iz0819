package com.iz0819.www.multithreading;

class newThread implements Runnable {
    Thread t;

    newThread() {
        t=new Thread(this, "Demo Thread");
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
public class ChildThreads {
    public static void main(String args[]) {
        newThread nt = new newThread();
        nt.t.start();

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("Main thread " + n);
                Thread.sleep(510);
            }
        } catch(InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
