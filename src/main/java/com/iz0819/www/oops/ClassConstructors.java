package com.iz0819.www.oops;

class A {
    A() {
        System.out.println("com.iz0819.www.A's constructor");
    }
}

class B extends A {
    B() {
        System.out.println("com.iz0819.www.B's constructor");
    }
}

class C extends B {
    C() {
        System.out.println("com.iz0819.www.C's constructor");
    }
}
public class ClassConstructors {
    public static void main(String args[]) {
        C c = new C();
    }
}
