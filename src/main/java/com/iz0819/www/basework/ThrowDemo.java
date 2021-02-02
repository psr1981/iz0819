package com.iz0819.www.basework;

public class ThrowDemo {
    static void demoproc() {
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            System.out.println("Caught inside demoproc.");
            throw e;
        }
    }

    public static void main(String arg[]) {
        try {
            demoproc();
        }
        catch(NullPointerException e) {
            System.out.println("Recaught " + e);
        }
    }
}
