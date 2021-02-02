package com.iz0819.www.basework;

public class ArrayTest {
    public static void main(String[] args) {
        int arrSize=20;
        int myarr1[] = { 20, 30, 40, 50};
        int myarr2[];
        myarr2 = new int[arrSize];

        for(int i =0; i < myarr1.length;i++) {
            System.out.println("i[" + i + "] = " +  myarr1[i]);
        }

        System.out.println(myarr2.length);
    }
}
