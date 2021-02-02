package com.iz0819.www.oops;

class A5 {
   // final void meth() {
   void meth() {
        System.out.println("this is final method");
    }
}

class B5 extends A5 {
    void meth(){
        System.out.println("Illegal");
    }
}

public class finalKeywordTest {
    public static void main(String args[]) {
        B5 b5 = new B5();
    }
}
