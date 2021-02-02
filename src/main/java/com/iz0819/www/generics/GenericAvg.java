package com.iz0819.www.generics;


class Avg<T extends  Number> {
    T[] obj;

    Avg(T[] o) {
        obj = o;
    }

    double average() {
        double sum = 0.0;
        for(int i =0; i < obj.length; i++) {
            sum += obj[i].doubleValue();
        }
        double result = sum / obj.length;
        return result;
    }
}

public class GenericAvg {
    public static void main(String args[]) {
        Avg<Integer> obj1 = new Avg<Integer>(new Integer[] {1, 8, 3, 4, 5});
        System.out.println("Average = " + obj1.average());
    }
}
