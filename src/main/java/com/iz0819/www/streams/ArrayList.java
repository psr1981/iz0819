package com.iz0819.www.streams;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayList {
    public static void main(String args[]) {
        String str1[] = { "a", "b", "c", "d" };
        Integer int1[] = {10, 20, 30, 40, 50,60,70};
        List<Integer> int2 = List.of(10,20,100,200,1,3,4,5,6);
        List<Integer> int3 =  int2.stream().filter(x -> x>10).sorted().collect(Collectors.toList());
        System.out.println("\nint2");
        int2.forEach(System.out::println);

        System.out.println("\nint3");
        int3.forEach(System.out::println);

        System.out.println("\nint4");
        int2.stream().map(x -> x*2).filter(x -> x>20).forEach(System.out::println);
        System.out.println( "\nmax "  + int2.stream().max(Integer::compare).get());
        System.out.println( "\nsum1 "  + int2.stream().reduce((a,b) -> a*b).get());
        System.out.println( "\nsum2 "  + int2.stream().reduce(1,(a,b) -> a*b));




    }

}
