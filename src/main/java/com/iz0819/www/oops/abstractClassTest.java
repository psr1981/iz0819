package com.iz0819.www.oops;

abstract class A41 {
    abstract void callme();
    void callmetoo() {
        System.out.println("This is a concrete method");
    }
}

class B41 extends A41 {
    void callme() {
        System.out.println("B4's implementation of call me");
    }
}

public class abstractClassTest {
    public static void main(String[] args) {
        //A4 a = new A4();
        B41 b = new B41();
        b.callme();
        b.callmetoo();
    }
}
