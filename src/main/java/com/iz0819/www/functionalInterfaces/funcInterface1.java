package com.iz0819.www.functionalInterfaces;

@FunctionalInterface
interface funcTest {
    void print(int x);
    String toString();
}

public class funcInterface1 {
    public static void main(String args[]) {
        funcTest f = (x -> System.out.println(x));
        f.print(10);
    }

}
