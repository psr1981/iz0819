package com.iz0819.www.generics;

class Util {
    static <T extends Comparable<T>, V extends T> boolean isIn (T x, V[] obj ) {
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].equals(x)) return true;
        }
        return false;
    }
}

public class GenericMethodTest {
    public static void main(String args[]) {
        System.out.println(Util.isIn(20, new Integer[]{2,2,3,4,5}));
    }
}
