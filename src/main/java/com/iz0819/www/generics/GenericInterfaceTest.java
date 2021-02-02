package com.iz0819.www.generics;

interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

class minMaxClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    minMaxClass(T[] o) { vals=o; }

    @Override
    public T min() {
        T v = vals[0];
        for(int i=0; i < vals.length;i++) {
            if (vals[i].compareTo(v) < 0)  v=vals[i];
        }
        return v;
    }

    @Override
    public T max() {
        T v = vals[0];
        for(int i=0; i < vals.length;i++) {
            if (vals[i].compareTo(v) > 0)  v=vals[i];
        }
        return v;
    }
}
public class GenericInterfaceTest {
    public static void main(String args[]) {
        minMaxClass<Integer> iobj = new minMaxClass<>(new Integer[]{1,2,3,4,5,6});
        System.out.println(iobj.min());
        System.out.println(iobj.max());

        minMaxClass<Character> cobj = new minMaxClass<>(new Character[]{'a','x','y','m','o','j'});
        System.out.println(cobj.min());
        System.out.println(cobj.max());

    }
}
