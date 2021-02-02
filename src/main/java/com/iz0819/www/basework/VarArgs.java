package com.iz0819.www.basework;

public class VarArgs {
    static void vaTest(int ... v) {
        System.out.println("number of arguments "  + v.length + " Contents");

        for(int x : v) {
            System.out.print(x + " " );
        }
        System.out.println();
    }

    public static void main (String argsp[]) {
        vaTest(10);
        vaTest(1,2,3,4);
        vaTest(100);
    }
}
