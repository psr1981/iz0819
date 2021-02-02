package com.iz0819.www.multithreading;

class Resource1 {
    String resourceName=this.getClass().getName();
    public String getResourceName() {
        return resourceName;
    }
}

class Resource2 {
    String resourceName=this.getClass().getName();
    public String getResourceName() {
        return resourceName;
    }
}

class Thread10 implements Runnable {
    Thread t;
    Resource1 r1;
    Resource2 r2;
    public Thread10(String name, Resource1 r1, Resource2 r2) {
        this.r1 = r1;
        this.r2 = r2;
        t = new Thread(this,name);
        t.start();
    }

    @Override
    public void run() {
        while(true) {
            synchronized (r1) {
                synchronized (r2) {
                    System.out.println(r1.getResourceName() + " " + r2.getResourceName());
                }
            }
        }
    }
}

class Thread11 implements Runnable {
    Thread t;
    Resource1 r1;
    Resource2 r2;
    public Thread11(String name, Resource1 r1, Resource2 r2) {
        this.r1 = r1;
        this.r2 = r2;
        t = new Thread(this,name);
        t.start();
    }

    @Override
    public void run() {
        while(true) {
            synchronized (r2) {
                synchronized (r1) {
                    System.out.println(r2.getResourceName() + " " + r1.getResourceName());
                }
            }
        }
    }
}

public class MultithreadedDeadLock {
    public static void main(String args[]) {
        Resource1 r1 = new Resource1();
        Resource2 r2 = new Resource2();

        Thread10 t10 = new Thread10("com.iz0819.www.Thread10",r1,r2);
        Thread11 t11 = new Thread11("com.iz0819.www.Thread11",r1,r2);

    }

}
