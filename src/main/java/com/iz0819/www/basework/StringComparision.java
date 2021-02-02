package com.iz0819.www.basework;

import java.text.MessageFormat;

public class StringComparision {
    public static void main(String args[]) {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = "";

        System.out.println("String Comparision  - changed");

        System.out.println(MessageFormat.format("s3.isBlank = {0}", s3.isBlank()) );
    }
}
