package com.iz0819.www.basework;

public class ThrowsDemo {
    static void throwOne() throws IllegalAccessException {
        System.out.println("Inside throwOne");
        throw new IllegalAccessException("throwone");
    }

    public static void main(String args[]) {
        try {
            throwOne();
        }
        catch(IllegalAccessException e) {
            System.out.println("IllegalAccessException thrown");
        }
    }
}
