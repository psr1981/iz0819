package com.iz0819.www.oops;

class A1 {
    void callme(){
        System.out.println("Inside com.iz0819.www.A's callme method");
    }
}

class B1 extends A1 {
    void callme() {
        System.out.println("Inside com.iz0819.www.B's callme method");
    }
}

class C1 extends B1 {
    void callme() {
        System.out.println("Inside com.iz0819.www.C's callme method");
    }
}

public class DynamicDispatchMethods {
    public static void main(String args[]) {
        A1 a = new A1();
        B1 b = new B1();
        C1 c = new C1();

        A1 r;

        r = a;
        r.callme();

        r = b;
        r.callme();

        r = c;
        r.callme();

    }
}
