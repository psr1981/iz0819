package com.iz0819.www.generics;

class TwoGen<T extends Number,V> {
    T obj1;
    V obj2;

    TwoGen(T o1, V o2) {
        this.obj1=o1;
        this.obj2=o2;
    }

    void showTypes() {
        System.out.println("Type of T is " + this.obj1.getClass().getName());
        System.out.println("Type of V is " + this.obj2.getClass().getName());
    }

    T getObj1() {
        return this.obj1;
    }

    V getObj2() {
        return this.obj2;
    }
}

public class GenericTwoTypes {
    public static void main(String args[]) {
        TwoGen<Integer, String> tgObj1 = new TwoGen<>(20,"Generics");
        tgObj1.showTypes();

        System.out.println("value obj1 : " + tgObj1.getObj1() );
        System.out.println("value obj2 : " + tgObj1.getObj2() );
    }
}
