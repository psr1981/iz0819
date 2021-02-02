package com.iz0819.www.oops;

import java.awt.desktop.AppForegroundListener;

public class Autoboxing {

    public static void main (String argsp[]) {
        Integer iObj1 = Integer.valueOf(100);
        Integer iObj2 = Integer.parseInt("100");
        int i1 = Integer.parseInt("200");
        int i2 = iObj1.intValue();



        System.out.println("iObj1=" + iObj1);
        System.out.println("iObj2=" + iObj2);


    }
}
